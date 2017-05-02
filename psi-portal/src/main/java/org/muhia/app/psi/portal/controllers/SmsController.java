package org.muhia.app.psi.portal.controllers;

/*
 
  Copyright 2015-2016 the original author or authors.
 
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 
 
  Generated on 07-Nov-16 12:26 
 
 */

import org.muhia.app.psi.config.CustomUtilities;
import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.config.sms.properties.SmsKannelConnectorProperties;
import org.muhia.app.psi.orm.model.ProductPrvTemplates;
import org.muhia.app.psi.orm.model.SmsNotification;
import org.muhia.app.psi.orm.model.SmsRegistry;
import org.muhia.app.psi.portal.PortalApplication;
import org.muhia.app.psi.portal.eventbus.DashboardEvent;
import org.muhia.app.psi.portal.service.orm.IUssdRequestsProcessorService;
import org.muhia.app.psi.portal.service.orm.IWorkOrderProcessingService;
import org.muhia.app.psi.portal.service.sms.ISmsBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 07-Nov-16. 
  for package org.muhia.app.psi.portal.controllers
*/
@RestController
public class SmsController {
    @Autowired
    private ISmsBrokerService smsBrokerService;

    @Autowired
    private SmsKannelConnectorProperties smsKannelConnectorProperties;

    @Autowired
    private IUssdRequestsProcessorService requestsProcessorService;

    @Autowired
    private IWorkOrderProcessingService orderProcessingService;

    @Autowired
    private CustomUtilities utilities;

    @Autowired
    private MenuMessages menuMessages;

    @Autowired
    private OrderProcessingProperties orderProcessingProperties;

    private List<String> fetchMessageParameters(SmsNotification notification) {
        List<String> results = new ArrayList<>();
        Optional<SmsNotification> optionalSmsNotification = Optional.ofNullable(notification);
        optionalSmsNotification.ifPresent(smsNotification -> {
            if (smsNotification.getPlaceHolder1() != null) results.add(0, smsNotification.getPlaceHolder1());
            if (smsNotification.getPlaceHolder2() != null) results.add(1, smsNotification.getPlaceHolder2());
            if (smsNotification.getPlaceHolder3() != null) results.add(2, smsNotification.getPlaceHolder3());
            if (smsNotification.getPlaceHolder4() != null) results.add(3, smsNotification.getPlaceHolder4());
            if (smsNotification.getPlaceHolder5() != null) results.add(4, smsNotification.getPlaceHolder5());
        });

        return results;
    }

    @RequestMapping("/sms/smsbroker")
    public ResponseEntity<String> receiveAndProcessSmsMessages(
            @RequestParam(value = "subscriber", defaultValue = "test") String subscriber,
            @RequestParam(value = "sender", defaultValue = "testsender") String sender,
            @RequestParam(value = "message", defaultValue = "testmessage") String message) {
        final String[] results = {"Invalid SMS Destination "+sender};

//        Optional<UssdCodes> ussdCodesOptional = smsBrokerService.fetchUssdCodesByUssdCode(sender);
        try {
            /*
                Log SMS As Received
             */
            SmsRegistry smsRegistry = new SmsRegistry();
            smsRegistry.setDirection(smsKannelConnectorProperties.getSmsInKeyword());
            smsRegistry.setMessageText(message);
            smsRegistry.setReceivedDate(new Date());
            smsRegistry.setSender(subscriber);
            smsRegistry.setShortCode(sender);
            smsRegistry.setSubno(subscriber);
            final SmsRegistry finalSmsRegistry = smsBrokerService.registerIncomingSms(smsRegistry);
            smsBrokerService.fetchUssdCodesByUssdCode(sender).ifPresent(uc -> {

                if (smsBrokerService.fetchSmsResponsesBySmsCode(uc).isPresent()) {
                    smsBrokerService.fetchSmsResponsesBySmsCode(uc).ifPresent(smsResponses -> {
                                String senderCode = smsResponses.getResponseText().getSender() == null ? smsKannelConnectorProperties.getSender() : smsResponses.getResponseText().getSender();
                        if (smsResponses.getAutoResopond().equals((long) smsKannelConnectorProperties.getSmsInAutoResponseKeyword())) {
                                    String autoResponseText = smsResponses.getResponseText().getDescription();
                                    List<String> placeHolders = fetchMessageParameters(smsResponses.getResponseText());
                                    String successSmsStr = utilities.addParametersToMessage(smsResponses.getResponseText().getDescription() == null ? autoResponseText : smsResponses.getResponseText().getDescription(), placeHolders.toArray());
                                    results[0] = "OK: Autorespond("+sender+") configured\n";

                                    smsBrokerService.registerSmsForSending(successSmsStr, subscriber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());
                                } else {
                            results[0] = "OK: Autorespond("+sender+") default response\n";
                                    smsBrokerService.registerSmsForSending(smsKannelConnectorProperties.getDefaultResponse(), subscriber, senderCode, smsKannelConnectorProperties.getSmsOutKeyword(), new Date(), smsKannelConnectorProperties.getSmsOutInitStatus());
                                }
                            }
                    );

                } else {
                    /*
                        DONE: Decide how deal with this
                     */
                    Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Sms with an invalid code"+uc+" received, "+ smsRegistry.toString());

                }
                /*
                    DONE: Link SMS to work order creation
                 */


                String[] msgs = message.split(smsKannelConnectorProperties.getSeparatorKeyword());
                requestsProcessorService.findProductParametersBySmSKeyword(msgs[0].toUpperCase()).ifPresent(productParameters -> {
                    Optional<ProductPrvTemplates> prvTemplates = Optional.ofNullable(orderProcessingService.findProductPrvTemplatesByProductIdAndStatus(productParameters.getProductId(), menuMessages.getStatusActive()));
                    prvTemplates.ifPresent(productPrvTemplates -> {
                        /*
                            Create a new order
                            Check that the phone number is allowed to submit orders
                            Start with a product map
                            DONE: Map has gone wack to recheck again by 23-Dec-16
                         */
                        Map<String, String> result = new HashMap<>();
                        try {
                            result.putIfAbsent(productParameters.getPlaceHolder1(), subscriber);
                            result.putIfAbsent(productParameters.getPlaceHolder2(), msgs[0]);
                            result.putIfAbsent(productParameters.getPlaceHolder3(), msgs[1]);
                            result.putIfAbsent(productParameters.getPlaceHolder4(), msgs[2]);
                            result.putIfAbsent(productParameters.getPlaceHolder5(), msgs[3]);
                            result.putIfAbsent(productParameters.getPlaceHolder6(), msgs[4]);
                            result.putIfAbsent(productParameters.getPlaceHolder7(), msgs[5]);
                            result.putIfAbsent(productParameters.getPlaceHolder8(), msgs[6]);
                            result.putIfAbsent(productParameters.getPlaceHolder9(), msgs[7]);
                            result.putIfAbsent(productParameters.getPlaceHolder10(), msgs[8]);

                        } catch (ArrayIndexOutOfBoundsException e) {
                            Logger.getLogger(this.getClass().getName()).log(Level.INFO, e.getMessage());
                        }


                        PortalApplication.asyncEventbusService().post(new DashboardEvent.SmsOrderCreationRequestEvent(finalSmsRegistry, message, productPrvTemplates.getProductId(), result));
                        finalSmsRegistry.setDeliveryStatus(new Long(orderProcessingProperties.getOrderSubmittedStatus()));
                        smsBrokerService.registerIncomingSms(finalSmsRegistry);


                    });
                });
            });

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            results[0] = smsKannelConnectorProperties.getDefaultErrorResponse();
        }


        return new ResponseEntity<>(results[0], HttpStatus.ACCEPTED);

    }
    
    @RequestMapping(value="/sms/sendbulk",
            method=RequestMethod.POST)
    public ModelAndView uploadSmsCsv(@RequestParam("smscsv") MultipartFile smscsv,
                                     @RequestParam("message") String message,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletRequest request){
        try {
            Boolean single;
            if(message.isEmpty()){
                single=false;
            }else{
                single=true;
            }
            DashboardEvent.SendBulkSmsEvent sendBulkSmsEvent = new DashboardEvent.SendBulkSmsEvent(smscsv,single,message);
            PortalApplication.dashBoardEventBusService().post(sendBulkSmsEvent);
            redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + smscsv.getOriginalFilename() + "!");
        
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("message",
                "File not uploaded!");
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        
        return new ModelAndView("redirect:/bulksms");
    }
    
    
    
    @RequestMapping(value = "/bulksms")
    public ModelAndView createBulkForm() {
        return new ModelAndView("/profile/bulksms");
    }
}

