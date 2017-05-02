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
 
 
  Generated on 26-Nov-16 20:39 
 
 */

import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import org.muhia.app.psi.orm.model.RecurringOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
  @author Kenneth Muhia <muhia@muhia.org> on 26-Nov-16. 
  for package org.muhia.app.tau.orm.repo
*/
public interface RecurringOrdersRepository extends JpaRepository<RecurringOrders, Long>{
    @Query("SELECT r FROM RecurringOrders r WHERE r.transactionDate = :date AND r.transactionStatus = :status")
    Optional<Collection<RecurringOrders>> listPendingTransactionsToday(@Param(value="date") Date date, @Param(value = "status") int status);
}
