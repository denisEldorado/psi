package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.orm.model.ProductsMaster;
import org.muhia.app.psi.orm.repo.ProductsMasterRepository;
import org.muhia.app.psi.portal.service.orm.IProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright 2015-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * <p>
 * Generated on 30-Oct-16 01:30
 */

/**
 * Created by ngatia
 * Project: psi
 * Package: ${PACKAGE_NAME}
 * Generated on: 1/11/17, 10:41
 */
@Service
public class ProductMasterService implements IProductMasterService {

    final ProductsMasterRepository productsMasterRepository;

    @Autowired
    public ProductMasterService(ProductsMasterRepository productsMasterRepository) {
        this.productsMasterRepository = productsMasterRepository;
    }

    @Override
    public List<ProductsMaster> getAll() {
        return productsMasterRepository.findAll();
    }

    @Override
    public ProductsMaster get(Long id) {
        return productsMasterRepository.findOne(id);
    }
}
