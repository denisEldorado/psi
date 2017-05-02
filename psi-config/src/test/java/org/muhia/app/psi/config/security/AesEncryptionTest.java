/**
 * 
 */
package org.muhia.app.psi.config.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	Project: psi-config
	Package: org.muhia.app.psi.config.security
  
	Generated on Dec 14, 2016

*/

/* 
 @author Kenneth Muhia <muhia@muhia.org>
 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AesEncryptionTest {
	@Autowired
	private AesEncryption aesEncryption;
	
	
	@Test
	public void testEncryption(){
		String keyValue = "0123456789ABCDEF";
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Generated IV is {0}", aesEncryption.generateIV(keyValue)));
		String plainVal = "password";
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("Using IV: {0} to hash {1} to {2}", aesEncryption.generateIV(keyValue), plainVal, aesEncryption.encrypt(keyValue, plainVal, aesEncryption.generateIV(keyValue))));
	}
	

}
