package org.muhia.app.psi.portal.eventbus;/*
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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Created by KennethKZMMuhia
  Project: psi
  Package: org.muhia.app.psi.portal.eventbus
  Generated on 25-Dec-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrincipalsServiceTest {
    @Autowired
    private IPrincipalsService principalsService;


    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        /*
            TODO: Expiry date is not working
         */
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

    @Test
    public void testcalculateExpiryDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.ENGLISH);
        int minutes = 10;
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Calculated " + sdf.format(calculateExpiryDate(minutes)));

//        String otp = principalsService.generateOneTimePin();
//        Principals principals = principalsService.findPrincipalsById(Long.valueOf("2"));
//        VerificationTokens tokens = principalsService.createVerificationTokenForUser(principals, otp, 10);
//        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Against "+sdf.format(tokens.getExpiryDate())+"For token "+tokens.toString() );
    }


}
