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

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

/*
    This class is used in our integration tests and it always returns the
    same time. This gives us the possibility to verify that the correct
    timestamps are saved to the database.

    Created by Kenneth Muhia <muhia@muhia.org>
    Project: taus
    Package: org.muhia.app.psi.orm.model.auditors
    Date: 02-Jan-17.
*/
public class ConstantDateTimeService implements IDateTimeService {
    public static final String CURRENT_DATE_AND_TIME = getConstantDateAndDate();

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_ZONED_DATE_TIME;

    private static String getConstantDateAndDate() {
        return "2015-07-19T12:52:28" + getSystemZoneOffset() + getSystemZoneId();
    }

    private static String getSystemZoneOffset() {
        return ZonedDateTime.now().getOffset().toString();
    }

    private static String getSystemZoneId() {
        return "[" + ZoneId.systemDefault().toString() + "]";
    }

    @Override
    public ZonedDateTime getCurrentDateAndDate() {
        ZonedDateTime constantDateAndDate = ZonedDateTime.from(FORMATTER.parse(CURRENT_DATE_AND_TIME));

        Logger.getLogger(this.getClass().getName()).info(String.format("Returning constant date and time: %s", constantDateAndDate));

        return constantDateAndDate;
    }
}
