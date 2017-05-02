/**
 *
 * Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Generated on Aug 18, 2016 for  psi-config on package org.muhia.psi.config.security
 *
 */
package org.muhia.app.psi.config.security;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
class CustomTemplate {

    private final List<Character> source;
    private final int count;

    private final SecureRandom secureRandom = new SecureRandom();

    public CustomTemplate(List<Character> source, int count) {
        this.count = count;
        this.source = source;
    }

    public List<Character> addCharactersToList() {
        List<Character> taken = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            taken.add(source.get(secureRandom.nextInt(source.size())));
        }

        return taken;
    }

}
