package org.muhia.app.psi.config.security;

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
 
 
  Generated on 18-Nov-16 09:27 
 
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 18-Nov-16. 
  for package org.muhia.app.psi.config.security
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomPasswordGeneratorsTest {
    @Autowired
    private RandomPasswordGenerators passwordGenerators;

    @Test
    public void generateOneTimePin() {

        for (int i = 0; i < 10000; i++) {
            if (!passwordGenerators.isDoShuffle()){
                passwordGenerators.digits(6).shuffle();
            }
            Logger.getLogger(this.getClass().getName()).log(Level.INFO,passwordGenerators.generateRandomString());
        }
    }

}
