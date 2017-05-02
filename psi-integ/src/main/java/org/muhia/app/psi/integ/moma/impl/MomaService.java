package org.muhia.app.psi.integ.moma.impl;

import org.muhia.app.psi.config.moma.properties.MomaProperties;
import org.muhia.app.psi.integ.moma.IMomaService;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
  Created by mathenge
  Project: psi
  Package: ${PACKAGE_NAME}
  Generated on: 2/2/17, 04:50.
 */
@Service
public class MomaService implements IMomaService {


    @Override
    public String urlSubstitution(String url, MomaProperties mp, String retrievalPrefix, String retrievalMethod) {
        String replaceUrl = "";

        for (String momaUrlKeyword : mp.getMomaGatewayUrlKeywords()) {
            /*
              ip,port,userid,passwd,retrievalPrefix,retrievalMethod,frmdate,todate
             */

            /*
            DONE: Encode each item to ensure URL is valid
            TODO: Externalise
            */
            try {
                if (momaUrlKeyword.equals(mp.getMomaKeywordIp())) {
                    replaceUrl = url.replace(momaUrlKeyword, URLEncoder.encode(mp.getMomaGatewayIp(), mp.getMomaGatewayDefaultEncoding()));
                } else if (momaUrlKeyword.equals(mp.getMomaKeywordPort())) {
                    replaceUrl = url.replace(momaUrlKeyword, URLEncoder.encode(mp.getMomaGatewayPort(), mp.getMomaGatewayDefaultEncoding()));
                } else if (momaUrlKeyword.equals(mp.getMomaKeywordRetrievalPrefix())) {
                    replaceUrl = url.replace(momaUrlKeyword, URLEncoder.encode(retrievalPrefix, mp.getMomaGatewayDefaultEncoding()));
                } else if (momaUrlKeyword.equals(mp.getMomaKeywordRetrievalMethod())) {
                    replaceUrl = url.replace(momaUrlKeyword, URLEncoder.encode(retrievalMethod, mp.getMomaGatewayDefaultEncoding()));
                } else {
                    throw new IllegalArgumentException("Invalid parameter for MOMA keywords: " + momaUrlKeyword);
                }
            } catch (UnsupportedEncodingException | IllegalArgumentException e) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
            url = replaceUrl;
        }

        return url;

    }


}
