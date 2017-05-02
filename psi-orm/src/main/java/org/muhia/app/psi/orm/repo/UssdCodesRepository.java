package org.muhia.app.psi.orm.repo;

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
 
 
  Generated on 07-Nov-16 13:18 
 
 */

import org.muhia.app.psi.orm.model.UssdCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 07-Nov-16. 
  for package org.muhia.app.tau.orm.repo
*/
@Repository
public interface UssdCodesRepository extends JpaRepository<UssdCodes, Long> {

    Optional<UssdCodes> findUssdCodesByUssdCode(String ussdCode);

    @Query("select distinct u from UssdCodes u where u.ussdCode = :ussdCode and u.status = :status")
    Optional<UssdCodes> findUssdCodesByUssdCodeAndStatus(@Param("ussdCode") String ussdCode, @Param("status") int status);


}
