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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.config.security.properties.RandomHashProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Kenneth Muhia <muhia@muhia.org>
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OneTimePasswordGenerationTest {

    @Autowired
    private RandomHashProperties rhp;
    @Autowired
    private RandomPasswordGenerators oneTimePasswordGenerator;

    @Test
    public void testOneTimePasswordGeneration() {
//		oneTimePasswordGenerator = new RandomPasswordGenerators(rhp);
        int lowerCaseCount = rhp.getMaxLength() - (rhp.getDigitsCount() + rhp.getSpecialCharsCount() + rhp.getAlphaCount());

        oneTimePasswordGenerator.lowerCase(lowerCaseCount).digits(rhp.getDigitsCount()).specials(rhp.getSpecialCharsCount()).upperCase(rhp.getAlphaCapsCount()).shuffle();

        for (int i = 0; i < 2; i++) {

            Logger.getLogger(OneTimePasswordGenerationTest.class.getName()).log(Level.INFO, "Generated password is {0}", new Object[]{oneTimePasswordGenerator.generateRandomString()});
        }

    }

    @Test
    public void testOTPUsingDigits(){
        oneTimePasswordGenerator.digits(6).shuffle();
        for (int i = 0; i < 200; i++) {

            Logger.getLogger(OneTimePasswordGenerationTest.class.getName()).log(Level.INFO, "Generated password is {0}", new Object[]{oneTimePasswordGenerator.generateRandomString()});
        }
    }

}
