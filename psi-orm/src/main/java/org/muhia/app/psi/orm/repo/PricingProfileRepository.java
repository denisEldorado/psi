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
 
 
  Generated on 02-Nov-16 10:08 
 
 */

import org.muhia.app.psi.orm.model.PricingProfile;
import org.muhia.app.psi.orm.model.ProductsMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 02-Nov-16. 
  for package org.muhia.app.tau.orm.repo
*/
public interface PricingProfileRepository extends JpaRepository<PricingProfile,Long> {
    @Query("SELECT p FROM PricingProfile p WHERE p.productId = :productId")
    Optional<PricingProfile> findFirstPricingProfileByProductId(@Param(value="productId") ProductsMaster productId);
}
