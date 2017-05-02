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

import org.muhia.app.psi.orm.model.*;
import org.muhia.app.psi.orm.repo.*;
import org.muhia.app.psi.portal.service.orm.IBankingOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by KennethKZMMuhia
 * Project: psi
 * Package: org.muhia.app.psi.portal.service.orm.impl
 * Generated on: 21-Apr-17, 19:59
 */
@Service
public class BankingOperationsService implements IBankingOperationsService {
    private final BanksRepository banksRepository;
    private final BankAccountsRepository bankAccountsRepository;
    private final TransactionRequestsRepository transactionRequestsRepository;
    private final BankChargesRepository bankChargesRepository;
    private final AccountTypesRepository accountTypesRepository;
    private final BankBranchesRepository bankBranchesRepository;
    private final CurrenciesRepository currenciesRepository;
    private final TransactionCategoriesRepository transactionCategoriesRepository;

    @Autowired
    public BankingOperationsService(BanksRepository banksRepository, BankAccountsRepository bankAccountsRepository, TransactionRequestsRepository transactionRequestsRepository, BankChargesRepository bankChargesRepository, AccountTypesRepository accountTypesRepository, BankBranchesRepository bankBranchesRepository, CurrenciesRepository currenciesRepository, TransactionCategoriesRepository transactionCategoriesRepository) {
        this.banksRepository = banksRepository;
        this.bankAccountsRepository = bankAccountsRepository;
        this.transactionRequestsRepository = transactionRequestsRepository;
        this.bankChargesRepository = bankChargesRepository;
        this.accountTypesRepository = accountTypesRepository;
        this.bankBranchesRepository = bankBranchesRepository;
        this.currenciesRepository = currenciesRepository;
        this.transactionCategoriesRepository = transactionCategoriesRepository;
    }

    @Override
    public Optional<Banks> findBanksByBankname(String bankname) {
        return banksRepository.findBanksByBankname(bankname);
    }

    @Override
    public Optional<Banks> findBanksByBankCharges(BankCharges bankCharges) {
        return banksRepository.findBanksByBankCharges(bankCharges);
    }

    @Override
    public Optional<BankAccounts> findBankAccountsByAccNumber(String accNumber) {
        return bankAccountsRepository.findBankAccountsByAccNumber(accNumber);
    }

    @Override
    public Optional<BankAccounts> findBankAccountsByUserId(Principals userId) {
        return bankAccountsRepository.findBankAccountsByUserId(userId);
    }

    @Override
    public Optional<BankAccounts> findBankAccountsById(Long id) {
        return bankAccountsRepository.findBankAccountsById(id);
    }

    @Override
    public BankAccounts saveBankAccounts(BankAccounts bankAccounts) {
        return bankAccountsRepository.save(bankAccounts);
    }

    @Override
    public void deleteBankAccounts(BankAccounts bankAccounts) {
        bankAccountsRepository.delete(bankAccounts);

    }

    @Override
    public Optional<BankCharges> findBankChargesByProductId(ProductsMaster productsMaster) {
        return bankChargesRepository.findBankChargesByProductId(productsMaster);
    }

    @Override
    public Optional<BankCharges> findBankChargesById(Long id) {
        return bankChargesRepository.findBankChargesById(id);
    }

    @Override
    public BankCharges saveBankCharges(BankCharges bankCharges) {
        return bankChargesRepository.save(bankCharges);
    }

    @Override
    public void deleteBankCharges(BankCharges bankCharges) {
        bankChargesRepository.delete(bankCharges);
    }

    @Override
    public Optional<TransactionRequests> findTransactionRequestsByTransactionStatus(int transactionStatus) {
        return transactionRequestsRepository.findTransactionRequestsByTransactionStatus(transactionStatus);
    }

    @Override
    public Optional<TransactionRequests> findTransactionRequestsByTransactionSerAndServiceRequest(ServiceRequests serviceRequests) {
        return transactionRequestsRepository.findTransactionRequestsByServiceRequest(serviceRequests);
    }

    @Override
    public TransactionRequests saveTransactionRequests(TransactionRequests transactionRequests) {
        return transactionRequestsRepository.save(transactionRequests);
    }

    @Override
    public void deleteTransactionRequests(TransactionRequests transactionRequests) {
        transactionRequestsRepository.delete(transactionRequests);
    }

    @Override
    public Optional<AccountTypes> findAccountTypesByAcctypecode(String acctypecode) {
        return accountTypesRepository.findAccountTypesByAcctypecode(acctypecode);
    }

    @Override
    public Optional<AccountTypes> findAccountTypesById(Long id) {
        return accountTypesRepository.findAccountTypesById(id);
    }

    @Override
    public AccountTypes saveAccountTypes(AccountTypes accountTypes) {
        return accountTypesRepository.save(accountTypes);
    }

    @Override
    public void deleteAccountTypes(AccountTypes accountTypes) {
        accountTypesRepository.delete(accountTypes);
    }

    @Override
    public Optional<BankBranches> findBankBranchesByBranchname(String branchname) {
        return bankBranchesRepository.findBankBranchesByBranchname(branchname);
    }

    @Override
    public Optional<BankBranches> findBankBranchesById(Long id) {
        return bankBranchesRepository.findBankBranchesById(id);
    }

    @Override
    public BankBranches saveBankBranches(BankBranches bankBranches) {
        return bankBranchesRepository.save(bankBranches);
    }

    @Override
    public void deleteBankBranches(BankBranches bankBranches) {
        bankBranchesRepository.delete(bankBranches);
    }

    @Override
    public Optional<Currencies> findCurrenciesByCurrencycode(String currencycode) {
        return currenciesRepository.findCurrenciesByCurrencycode(currencycode);
    }

    @Override
    public Optional<Currencies> findCurrenciesById(Long id) {
        return currenciesRepository.findCurrenciesById(id);
    }

    @Override
    public Currencies saveCurrencies(Currencies currencies) {
        return currenciesRepository.save(currencies);
    }

    @Override
    public void deleteCurrencies(Currencies currencies) {
        currenciesRepository.delete(currencies);
    }

    @Override
    public Optional<TransactionCategories> findTransactionCategoriesByTrantype(String trantype) {
        return transactionCategoriesRepository.findTransactionCategoriesByTrantype(trantype);
    }

    @Override
    public Optional<TransactionCategories> findTransactionCategoriesById(Long id) {
        return transactionCategoriesRepository.findTransactionCategoriesById(id);
    }

    @Override
    public TransactionCategories saveTransactionCategories(TransactionCategories transactionCategories) {
        return transactionCategoriesRepository.save(transactionCategories);
    }

    @Override
    public void deleteTransactionCategories(TransactionCategories transactionCategories) {
        transactionCategoriesRepository.delete(transactionCategories);
    }
}
