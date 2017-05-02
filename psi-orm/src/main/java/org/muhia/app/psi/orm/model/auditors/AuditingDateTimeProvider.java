package org.muhia.app.psi.orm.model.auditors;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.GregorianCalendar;

/*

 * This class obtains the current time by using a {@link IDateTimeService}
 * object. The reason for this is that we can use a different implementation in our integration tests.
 *
 * In other words:
 * <ul>
 *     <li>
 *         Our application always returns the correct time because it uses the
 *         {@link CurrentDateDateDateService} class.
 *     </li>
 *     <li>
 *         When our integration tests are running, we can return a constant time which gives us the possibility
 *         to assert the creation and modification times saved to the database.
 *     </li>
 * </ul>
 *
 * @author Petri Kainulainen
 *
    Created by Kenneth Muhia <muhia@muhia.org>
    Project: taus
    Package: org.muhia.app.psi.orm.model.auditors
    Date: 02-Jan-17.
*/
@Component
public class AuditingDateTimeProvider implements DateTimeProvider {

    private IDateTimeService dateDateService;

    @Autowired
    public AuditingDateTimeProvider(IDateTimeService dateTimeService) {
        this.dateDateService = dateTimeService;
    }

    @Override
    public Calendar getNow() {
        return GregorianCalendar.from(dateDateService.getCurrentDateAndDate());
    }


}
