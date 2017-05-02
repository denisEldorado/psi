package org.muhia.app.psi.portal.service.orm.impl;/**
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

import org.muhia.app.psi.config.menu.ussd.MenuMessages;
import org.muhia.app.psi.orm.model.BankCharges;
import org.muhia.app.psi.orm.model.ProductsMaster;
import org.muhia.app.psi.portal.service.orm.IProductMasterService;
import org.muhia.app.psi.portal.service.orm.IUssdPrePostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.portal.service.orm.impl
 * Generated on: 22-Apr-17, 10:34
 */
@Service
public class UssdPrePostProcessor implements IUssdPrePostProcessor {

    private final IProductMasterService productMasterService;
    private final MenuMessages menuMessages;
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public UssdPrePostProcessor(IProductMasterService productMasterService, MenuMessages menuMessages) {
        this.productMasterService = productMasterService;
        this.menuMessages = menuMessages;
    }


//    @Override
//    public String loanRate(String query, Long productId) {
//        List<BankCharges> charges = em.createQuery(query, BankCharges.class).getResultList();
//        final String[] rate = {""};
//        ProductsMaster productsMaster = productMasterService.get(productId);
//        Optional<BankCharges> charge = charges.stream().filter(bankCharges -> bankCharges.getProductId().equals(productsMaster)).findAny();
//        charge.ifPresent(bankCharges -> {
//            rate[0] = bankCharges.getChargeAmount().toString() + bankCharges.getChargeCode();
//        });
//        return rate[0];
//    }

    @Override
    public String loanRate(Map<String, String> params) {
        final String[] rate = {""};

        String query = params.get(menuMessages.getLoanRateQueryKeyword());
        try {
            Long productId = Long.valueOf(params.get(menuMessages.getProductIdKeyword()));
            if (!query.equals("")) {
                List<BankCharges> charges = em.createQuery(query, BankCharges.class).getResultList();
                ProductsMaster productsMaster = productMasterService.get(productId);
                Optional<BankCharges> charge = charges.stream().filter(bankCharges -> bankCharges.getProductId().equals(productsMaster)).findAny();
                charge.ifPresent(bankCharges -> rate[0] = bankCharges.getChargeAmount().toString() + bankCharges.getChargeCode());
            }

        } catch (NumberFormatException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage() + "invalid Product Id value");
        }


        return rate[0];
    }
}
