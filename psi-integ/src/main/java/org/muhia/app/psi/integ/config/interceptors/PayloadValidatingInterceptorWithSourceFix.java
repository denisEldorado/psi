package org.muhia.app.psi.integ.config.interceptors;

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

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceTransformerException;
import org.springframework.ws.client.support.interceptor.PayloadValidatingInterceptor;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.integ.config.ke
    Generated on: 06-Feb-17.
*/
public class PayloadValidatingInterceptorWithSourceFix extends PayloadValidatingInterceptor {

    @Override
    protected Source getValidationResponseSource(WebServiceMessage response) {
        return transformSourceToStreamSourceWithStringReader(response.getPayloadSource());
    }

    Source transformSourceToStreamSourceWithStringReader(Source notValidatableSource) {
        final Source source;
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
            StringWriter writer = new StringWriter();
            transformer.transform(notValidatableSource, new StreamResult(writer));

            String transformed = writer.toString();
            StringReader reader = new StringReader(transformed);
            source = new StreamSource(reader);

        } catch (TransformerException transformerException) {
            throw new WebServiceTransformerException("Could not convert the source to a StreamSource with a StringReader", transformerException);
        }

        return source;
    }
}
