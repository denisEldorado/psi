package org.muhia.app.psi.orm.repo;/*
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

import org.muhia.app.psi.orm.model.SubscriberWhitelist;
import org.muhia.app.psi.orm.model.UssdCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
  Created by KennethKZMMuhia
  Project: taus
  Package: org.muhia.app.tau.orm.repo
  Generated on 21-Dec-16.
 */
@Repository
public interface SubscriberWhitelistRepository extends JpaRepository<SubscriberWhitelist, Long> {

    Optional<SubscriberWhitelist> findSubscriberWhitelistBySubno(String subno);


    Optional<SubscriberWhitelist> findSubscriberWhitelistBySubnoAndCode(String subno, UssdCodes code);
//    @Query("Select s from SubscriberWhitelist where subno= :subno and code= :code")
//    Optional<SubscriberWhitelist> findSubscriberWhitelistBySubnoAndCode(@Param("subno") String subno, @Param("code") String code);
}
