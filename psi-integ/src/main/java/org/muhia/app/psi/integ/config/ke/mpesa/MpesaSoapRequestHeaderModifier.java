package org.muhia.app.psi.integ.config.ke.mpesa;

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

import org.muhia.app.psi.config.integ.properties.MpesaProperties;
import org.muhia.app.psi.config.security.HashingImplementation;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.ObjectFactory;
import org.muhia.app.psi.integ.wsdl.mpesa.cbp.request.RequestSOAPHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.integ.config.mpesa
    Generated on: 05-Feb-17.
*/
@Component
public class MpesaSoapRequestHeaderModifier implements WebServiceMessageCallback {
    private final MpesaProperties properties;
    private final HashingImplementation hasher;

    @Autowired
    public MpesaSoapRequestHeaderModifier(MpesaProperties properties, HashingImplementation hasher) {
        this.properties = properties;
        this.hasher = hasher;
    }


    private Object generateHeader(MpesaProperties properties) {
        RequestSOAPHeader header = new RequestSOAPHeader();
        ObjectFactory objectFactory = new ObjectFactory();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(properties.getMpesaSdfHeaderTimestamp());
        header.setServiceId(hasher.getDecryptedValue(properties.getServiceId()));
        header.setSpId(hasher.getDecryptedValue(properties.getSpId()));
        /*
            DONE: The following will be the used to encrypt the password: BASE64(sha256(spId + Password + timeStamp))
         */
        header.setSpPassword(hasher.encryptSha2(hasher.getDecryptedValue(properties.getSpId()) + hasher.getDecryptedValue(properties.getSpPassword()) + simpleDateFormat.format(new Date())));
        header.setTimeStamp(simpleDateFormat.format(new Date()));

        return objectFactory.createRequestSOAPHeader(header);


    }

    /**
     * Execute any number of operations on the supplied {@code message}.
     *
     * @param message the message
     * @throws IOException          in case of I/O errors
     * @throws TransformerException in case of transformation errors
     */
    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {

        SoapMessage soapMessage = (SoapMessage) message;

        SoapHeader header = soapMessage.getSoapHeader();


        StringSource headerSource = new StringSource(prepareSecurityHeader());

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(headerSource, header.getResult());

    }

    private String prepareSecurityHeader() {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(RequestSOAPHeader.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(generateHeader(this.properties), sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
