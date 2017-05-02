package org.muhia.app.psi.integ.config.ke.crba;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.integ.ke.properties.CreditReferenceBureauAuthorityProperties;
import org.muhia.app.psi.integ.wsdl.crba.transunion.GetProduct102;
import org.muhia.app.psi.integ.wsdl.crba.transunion.GetProduct102Response;
import org.muhia.app.psi.integ.wsdl.crba.transunion.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.namespace.QName;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
  Copyright 2015-2017 the original author or authors.
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  
*/

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.integ.config.crba.ke
    Generated on: 05-Feb-17.
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditReferenceBureauAuthorityClientConfigurationTest extends WebServiceGatewaySupport {
    @Autowired
    private CreditReferenceBureauAuthorityProperties properties;
    @Autowired
    @Qualifier(value = "transunionCrbaWebServiceTemplate")
    private WebServiceTemplate transunionCrbaWebServiceTemplate;
    @Autowired
    private CrbaProductSoapHeaderModifier crbaProductSoapHeaderModifier;

    @Test
    public void getProduct102ResponseViaJaxb() {
        ObjectFactory objectFactory = new ObjectFactory();

//        ControllerKenyaImplService controllerKenya = new ControllerKenyaImplService();

        try {
            GetProduct102 product102 = objectFactory.createGetProduct102();
            product102.setUsername(properties.getCrbaTransunionUsername());
            product102.setPassword(properties.getCrbaTransunionPassword());
            product102.setCode(properties.getCrbaTransunionCode());
            product102.setNationalID("ID79903");
            product102.setReportReason(1);
            product102.setInfinityCode(properties.getCrbaTransunionInfinityCode());
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Product102 %s", product102.toString()));
//        product102.setName1("name1");
//            PersonalProfile personalProfile = new PersonalProfile();
//            personalProfile.setNationalID("ID79903");


//            product102.setPersonalProfile(personalProfile);
//            logJAXBRequest(new JAXBElement<>(new QName("http://ws.crbws.transunion.ke.co/", "getProduct102"), GetProduct102.class, product102));

//            GetProduct102Response product102Response = (GetProduct102Response) JAXBIntrospector.getValue(transunionCrbaWebServiceTemplate.marshalSendAndReceive(properties.getCrbaTransunionUrl(), new JAXBElement<>(new QName("http://ws.crbws.transunion.ke.co/", "getProduct102"), GetProduct102.class, product102), message -> ((SoapMessage) message).setSoapAction("")));
            GetProduct102Response product102Response = (GetProduct102Response) JAXBIntrospector.getValue(transunionCrbaWebServiceTemplate.marshalSendAndReceive(properties.getCrbaTransunionUrl(), new JAXBElement<>(new QName("http://ws.crbws.transunion.ke.co/", "getProduct102"), GetProduct102.class, product102), crbaProductSoapHeaderModifier));
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("[FullName= %s]", product102Response.getReturn().getPersonalProfile().getFullName()));


        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }


    }

//    private void logJAXBRequest(JAXBElement<GetProduct102> getProduct102JaxbElement) {
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Logging Web Service Request ...");
//
//        StringWriter writer = null;
//        StreamResult streamResult = null;
//        StringBuffer buffer = null;
//        try {
//            writer = new StringWriter();
//            streamResult = new StreamResult(writer);
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(GetProduct102.class);
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.marshal(getProduct102JaxbElement, streamResult);
//
//            buffer = writer.getBuffer();
//
//            Logger.getLogger(this.getClass().getName()).log(Level.INFO, String.format("JAXB Webservice Request : %s", buffer.toString()));
//
//            writer.close();
//
//        } catch (Exception ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, String.format("Exception generated while creating XML Logs of JAXB Request :%s", ex.getMessage()), ex);
//        }
//    }

}
