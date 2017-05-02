package org.muhia.app.psi.portal.service.orm;

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
 
 
  Generated on 30-Oct-16 20:54 
 
 */

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.RegisteredSaccos;
import org.muhia.app.psi.orm.model.RegistrationDocs;
import org.muhia.app.psi.orm.model.SaccoRegistration;

import java.util.Collection;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16. 
  for package org.muhia.app.psi.portal.service.orm
*/
public interface ISaccoRegistrationService {
    SaccoRegistration saveSaccoRegistration(SaccoRegistration saccoRegistration);

    Collection<SaccoRegistration> findSaccoRegistrationByUserId(Principals userId);

    RegistrationDocs saveRegistrationDocs(RegistrationDocs registrationDocs);

    Collection<RegistrationDocs> findRegistrationDocsByDocuments(String documents);

    RegistrationDocs findFirstRegistrationDocsByDocuments(String documents);


    RegisteredSaccos saveRegisteredSaccos(RegisteredSaccos registeredSaccos);

    Collection<RegisteredSaccos> findRegistredSaccosById(Long id);
    Collection<RegisteredSaccos> findRegistredSaccosBySacco(String sacco);

    RegisteredSaccos findFirstRegistredSaccosBySacco(String sacco);
}
