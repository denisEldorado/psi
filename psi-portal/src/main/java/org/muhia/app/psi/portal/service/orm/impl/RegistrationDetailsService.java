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
*/

import org.muhia.app.psi.orm.model.Organizations;
import org.muhia.app.psi.orm.model.RegistrationDetails;
import org.muhia.app.psi.orm.model.RegistrationDocs;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.repo.OrganizationsRepository;
import org.muhia.app.psi.orm.repo.RegistrationDetailsRepository;
import org.muhia.app.psi.orm.repo.RegistrationDocsRepository;
import org.muhia.app.psi.portal.service.orm.IRegistrationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/*
  Created by Kenneth Muhia <muhia@muhia.org>
  Project: psi
  Package: org.muhia.app.psi.portal.service.orm.impl
  Generated on: 22-Mar-17, 04:55.
 */
@Service
@Transactional
@CacheConfig(cacheNames = "ussdCache")
public class RegistrationDetailsService implements IRegistrationDetailsService {
    private final RegistrationDetailsRepository repository;
    private final OrganizationsRepository organizationsRepository;
    private final RegistrationDocsRepository docsRepository;

    @Autowired
    public RegistrationDetailsService(RegistrationDetailsRepository repository, OrganizationsRepository organizationsRepository, RegistrationDocsRepository docsRepository) {
        this.repository = repository;
        this.organizationsRepository = organizationsRepository;
        this.docsRepository = docsRepository;
    }

    @Override
    public RegistrationDetails save(RegistrationDetails details) {
        return repository.save(details);
    }

    @Override
    public void delete(RegistrationDetails details) {
        repository.delete(details);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(key = "#userMsisdn")
    public Optional<Collection<RegistrationDetails>> findRegistrationDetailsByOrganisation(Organizations organizations) {
        return repository.findRegistrationDetailsByOrganisation(organizations);
    }

    @Transactional(readOnly = true)
    @Override
    @Cacheable(key = "#userMsisdn")
    public Optional<RegistrationDetails> findRegistrationDetailsByServiceRequest(ServiceRequests serviceRequests) {
        return repository.findRegistrationDetailsByServiceRequest(serviceRequests);
    }

    @Override
    public Optional<RegistrationDetails> findRegistrationDetailsByServiceRequestAndUserRegistrationStatus(ServiceRequests serviceRequests, int userRegistrationStatus) {
        return repository.findRegistrationDetailsByServiceRequestAndUserRegistrationStatus(serviceRequests, userRegistrationStatus);
    }


    @Transactional(readOnly = true)
    @Override
    @Cacheable(key = "#userMsisdn")
    public Optional<Collection<RegistrationDetails>> findRegistrationDetailsByUserRegistrationStatus(int userRegistrationStatus) {
        return repository.findRegistrationDetailsByUserRegistrationStatus(userRegistrationStatus);
    }

    @Override
    public Optional<Organizations> findOrganizationsByOrganization(String organization) {
        return organizationsRepository.findOrganizationsByOrganization(organization);
    }

    @Override
    public Optional<Organizations> findOrganizationsById(Long id) {
        return organizationsRepository.findOrganizationsById(id);
    }

    @Override
    public Optional<RegistrationDocs> findFirstRegistrationDocsByDocuments(String documents) {
        return docsRepository.findFirstRegistrationDocsByDocuments(documents);
    }


}
