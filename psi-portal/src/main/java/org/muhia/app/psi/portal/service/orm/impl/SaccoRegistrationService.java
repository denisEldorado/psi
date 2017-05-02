package org.muhia.app.psi.portal.service.orm.impl;

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
 
 
  Generated on 30-Oct-16 21:01 
 
 */

import org.muhia.app.psi.portal.service.orm.ISaccoRegistrationService;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.RegisteredSaccos;
import org.muhia.app.psi.orm.model.RegistrationDocs;
import org.muhia.app.psi.orm.model.SaccoRegistration;
import org.muhia.app.psi.orm.repo.RegisteredSaccosRepository;
import org.muhia.app.psi.orm.repo.RegistrationDocsRepository;
import org.muhia.app.psi.orm.repo.SaccoRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 30-Oct-16. 
  for package org.muhia.app.psi.portal.service.orm.impl
*/
@Service
public class SaccoRegistrationService implements ISaccoRegistrationService {
    @Autowired
    private SaccoRegistrationRepository saccoRegistrationRepository;

    @Autowired
    private RegisteredSaccosRepository registeredSaccosRepository;

    @Autowired
    private RegistrationDocsRepository registrationDocsRepository;

    @Override
    public SaccoRegistration saveSaccoRegistration(SaccoRegistration saccoRegistration) {
        return saccoRegistrationRepository.save(saccoRegistration);
    }

    @Override
    public Collection<SaccoRegistration> findSaccoRegistrationByUserId(Principals userId) {

        return saccoRegistrationRepository.findSaccoRegistrationByUserId(userId).map(saccoRegistrations -> saccoRegistrations).orElse(null);
    }

    @Override
    public RegistrationDocs saveRegistrationDocs(RegistrationDocs registrationDocs) {
        return registrationDocsRepository.save(registrationDocs);
    }

    @Override
    public Collection<RegistrationDocs> findRegistrationDocsByDocuments(String documents) {
        return registrationDocsRepository.findRegistrationDocsByDocuments(documents).map( rds -> rds).orElse(null);
    }

    @Override
    public RegistrationDocs findFirstRegistrationDocsByDocuments(String documents) {
        return registrationDocsRepository.findFirstRegistrationDocsByDocuments(documents).orElse(null);
    }

    @Override
    public RegisteredSaccos saveRegisteredSaccos(RegisteredSaccos registeredSaccos) {

        return registeredSaccosRepository.save(registeredSaccos);
    }

    @Override
    public Collection<RegisteredSaccos> findRegistredSaccosById(Long id) {

        return registeredSaccosRepository.findRegistredSaccosById(id).map(rs -> rs).orElse(null);
    }

    @Override
    public Collection<RegisteredSaccos> findRegistredSaccosBySacco(String sacco) {

        return registeredSaccosRepository.findRegistredSaccosBySacco(sacco).map(rs -> rs).orElse(null);
    }

    @Override
    public RegisteredSaccos findFirstRegistredSaccosBySacco(String sacco) {
        return registeredSaccosRepository.findFirstRegistredSaccosBySacco(sacco).map(rs -> rs).orElse(null);
    }
}
