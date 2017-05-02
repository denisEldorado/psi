package org.muhia.app.psi.portal.service.orm;

import org.muhia.app.psi.orm.model.Priviledges;

import java.util.List;

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

/*
    Created by ngatia
    Project: psi
    Package: ${PACKAGE_NAME}
    Generated on: 1/17/17.
*/
public interface IPriviledgeService {
    List<Priviledges> getAll();

    Priviledges findOne(Long id);

    void save(Priviledges priviledges);


}