package org.muhia.app.psi.integ.config.ke.crba;

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

import org.muhia.app.psi.config.integ.ke.properties.CreditReferenceBureauAuthorityProperties;
import org.muhia.app.psi.integ.wsdl.crba.transunion.Header;
import org.muhia.app.psi.integ.wsdl.crba.transunion.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.IOException;
import java.io.StringWriter;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.integ.config.crba.ke
    Generated on: 05-Feb-17.
*/
@Component
public class CrbaProductSoapHeaderModifier implements WebServiceMessageCallback {
    private final CreditReferenceBureauAuthorityProperties properties;

    @Autowired
    public CrbaProductSoapHeaderModifier(CreditReferenceBureauAuthorityProperties properties) {
        this.properties = properties;
    }

    private Header generateProductHeader() {

        Header header = new Header();
        header.setCrbName(properties.getCrbaTransunionCrbName());
        header.setPdfId(properties.getCrbaTransunionPdfId());
        header.setReportType(properties.getCrbaTransunionReportType());
        header.setRequester(properties.getCrbaTransunionRequester());

        return header;


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
        StringSource headerSource = new StringSource(prepareProductHeader());
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(headerSource, header.getResult());
    }

    private String prepareProductHeader() {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(Header.class);
            Marshaller marshaller = context.createMarshaller();
            ObjectFactory objectFactory = new ObjectFactory();
            JAXBElement<Header> jh = new JAXBElement<>(new QName("http://ws.crbws.transunion.ke.co/", "Header"), Header.class, generateProductHeader());
            marshaller.marshal(jh, sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
