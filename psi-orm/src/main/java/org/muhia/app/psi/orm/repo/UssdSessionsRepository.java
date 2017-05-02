package org.muhia.app.psi.orm.repo;

import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.UssdSessions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

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
  

  Created by Kenneth Muhia <muhia@muhia.org>
  Project: taus
  Package: org.muhia.app.psi.orm.repo
  Generated on: 25-Feb-17, 16:25.
 */
public interface UssdSessionsRepository extends JpaRepository<UssdSessions, Long> {
    Optional<UssdSessions> findUssdSessionsBySessionIdAndUserId(String sessionId, Principals userId);
}
