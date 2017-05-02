package org.muhia.app.psi.portal.service.orm;/**
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

import org.muhia.app.psi.orm.model.*;

import java.util.Optional;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.portal.service.orm
 * Generated on: 21-Apr-17, 19:51
 */
public interface IBankingOperationsService {
    /**
     * Bank operations
     */
    Optional<Banks> findBanksByBankname(String bankname);

    Optional<Banks> findBanksByBankCharges(BankCharges bankCharges);

    /**
     * Bank Accounts Operations
     */
    Optional<BankAccounts> findBankAccountsByAccNumber(String accNumber);

    Optional<BankAccounts> findBankAccountsByUserId(Principals userId);

    Optional<BankAccounts> findBankAccountsById(Long id);

    BankAccounts saveBankAccounts(BankAccounts bankAccounts);

    void deleteBankAccounts(BankAccounts bankAccounts);

    /**
     * Bank Accounts Operations
     */
    Optional<BankCharges> findBankChargesByProductId(ProductsMaster productsMaster);

    Optional<BankCharges> findBankChargesById(Long id);

    BankCharges saveBankCharges(BankCharges bankCharges);

    void deleteBankCharges(BankCharges bankCharges);

    /**
     * Transaction Requests
     */
    Optional<TransactionRequests> findTransactionRequestsByTransactionStatus(int transactionStatus);

    Optional<TransactionRequests> findTransactionRequestsByTransactionSerAndServiceRequest(ServiceRequests serviceRequests);

    TransactionRequests saveTransactionRequests(TransactionRequests transactionRequests);

    void deleteTransactionRequests(TransactionRequests transactionRequests);

    /**
     * Bank Charge Types
     */
    Optional<AccountTypes> findAccountTypesByAcctypecode(String acctypecode);

    Optional<AccountTypes> findAccountTypesById(Long id);

    AccountTypes saveAccountTypes(AccountTypes accountTypes);

    void deleteAccountTypes(AccountTypes accountTypes);

    /**
     * Bank Branches
     */
    Optional<BankBranches> findBankBranchesByBranchname(String branchname);

    Optional<BankBranches> findBankBranchesById(Long id);

    BankBranches saveBankBranches(BankBranches bankBranches);

    void deleteBankBranches(BankBranches bankBranches);

    /**
     * Currencies
     */
    Optional<Currencies> findCurrenciesByCurrencycode(String currencycode);

    Optional<Currencies> findCurrenciesById(Long id);

    Currencies saveCurrencies(Currencies currencies);

    void deleteCurrencies(Currencies currencies);

    /**
     * Transaction Categories
     */
    Optional<TransactionCategories> findTransactionCategoriesByTrantype(String trantype);

    Optional<TransactionCategories> findTransactionCategoriesById(Long id);

    TransactionCategories saveTransactionCategories(TransactionCategories currencies);

    void deleteTransactionCategories(TransactionCategories transactionCategories);


}
