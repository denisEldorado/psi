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
*/

import org.muhia.app.psi.orm.model.Organizations;
import org.muhia.app.psi.orm.model.RegistrationDetails;
import org.muhia.app.psi.orm.model.RegistrationDocs;
import org.muhia.app.psi.orm.model.ServiceRequests;

import java.util.Collection;
import java.util.Optional;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service.orm
  Generated on: 22-Mar-17, 04:51.
 */
public interface IRegistrationDetailsService {
    /**
     * RegistrationDetails
     */
    RegistrationDetails save(RegistrationDetails details);

    void delete(RegistrationDetails details);

    Optional<Collection<RegistrationDetails>> findRegistrationDetailsByOrganisation(Organizations organizations);

    Optional<RegistrationDetails> findRegistrationDetailsByServiceRequest(ServiceRequests serviceRequests);

    //    Optional<RegistrationDetails> findRegistrationDetailsByServiceRequest(ServiceRequests serviceRequests);
    Optional<RegistrationDetails> findRegistrationDetailsByServiceRequestAndUserRegistrationStatus(ServiceRequests serviceRequests, int userRegistrationStatus);

    Optional<Collection<RegistrationDetails>> findRegistrationDetailsByUserRegistrationStatus(int userRegistrationStatus);

    /**
     * Organizations
     */
    Optional<Organizations> findOrganizationsByOrganization(String organization);
    Optional<Organizations> findOrganizationsById(Long id);

    /**
     * RegistrationDocs
     */
    Optional<RegistrationDocs> findFirstRegistrationDocsByDocuments(String documents);


}
