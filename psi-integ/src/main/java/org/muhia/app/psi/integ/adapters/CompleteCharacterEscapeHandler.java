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


import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.integ.adapters
  Generated on: 20-Mar-17, 16:30.
 */
@Service
public class CompleteCharacterEscapeHandler implements CharacterEscapeHandler {
    public CompleteCharacterEscapeHandler() {
        super();
    }

    /**
     *      * @param ch The array of characters.
     *      * @param start The starting position.
     *      * @param len The number of characters to use.
     *      * @param isAttVal true if this is an attribute value literal.
     *      
     */
    public void escape(char[] ch, int start, int len, boolean isAttVal, Writer out) throws IOException {
        int limit = start + len;
        for (int i = start; i < limit; i++) {
            char c = ch[i];
            if (c == '&' || c == '<' || c == '>' || (c == '\"' && isAttVal) || (c == '\'' && isAttVal)) {
                if (i != start) {
                    out.write(ch, start, i - start);
                }
                start = i + 1;
                switch (ch[i]) {
                    case '&':
                        out.write("&");
                        break;

                    case '<':
                        out.write("<");
                        break;

                    case '>':
                        out.write(">");
                        break;

                    case '\"':
                        out.write("\"");
                        break;

                    case '\'':
                        out.write("'");
                        break;
                }
            }
        }
        if (start != limit) {
            out.write(ch, start, limit - start);
        }

    }
}
