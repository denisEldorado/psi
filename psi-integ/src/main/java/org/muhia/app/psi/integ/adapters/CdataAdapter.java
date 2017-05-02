package org.muhia.app.psi.integ.adapters;
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
*/

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.integ
  Generated on: 20-Mar-17, 13:08.
 */
@Component
public class CdataAdapter extends XmlAdapter<String, String> {

    private static final String CDATA_END = "]]>";
    private static final String CDATA_BEGIN = "<![CDATA[";

    @Override
    public String unmarshal(String v) throws Exception {
        return String.format("%s%s%s", CDATA_BEGIN, v, CDATA_END);
    }

    @Override
    public String marshal(String v) throws Exception {
        if (v.startsWith(CDATA_BEGIN) && v.endsWith(CDATA_END)) {
            v = v.substring(CDATA_BEGIN.length(), v.length() - CDATA_END.length());
        }
        return v;

    }
}
