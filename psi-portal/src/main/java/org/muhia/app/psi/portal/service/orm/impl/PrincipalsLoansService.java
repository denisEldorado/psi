/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.config.integ.properties.ObopayKeProperties;
import org.muhia.app.psi.config.order.properties.OrderProcessingProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.repo.PrincipalLoansRepository;
import org.muhia.app.psi.portal.service.orchestrate.IObopayMethods;
import org.muhia.app.psi.portal.service.orm.IObaPayErrorCodesService;
import org.muhia.app.psi.portal.service.orm.IPaybackPeriodService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsLoansService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author mathenge
 */
@Service
public class PrincipalsLoansService implements IPrincipalsLoansService {

    private final PrincipalLoansRepository loansRepository;

    private final IPaybackPeriodService paybackService;

    private final ObopayKeProperties keProperties;

    private final IObaPayErrorCodesService errorCodesService;

    private final IObopayMethods obopayMethods;

    private final IPrincipalsService principalsService;

    private final OrderProcessingProperties orderProcessingProperties;

    @Autowired
    public PrincipalsLoansService(PrincipalLoansRepository loansRepository, IPaybackPeriodService paybackService, ObopayKeProperties keProperties, IObaPayErrorCodesService errorCodesService, IObopayMethods obopayMethods, IPrincipalsService principalsService, OrderProcessingProperties orderProcessingProperties) {
        this.loansRepository = loansRepository;
        this.paybackService = paybackService;
        this.keProperties = keProperties;
        this.errorCodesService = errorCodesService;
        this.obopayMethods = obopayMethods;
        this.principalsService = principalsService;
        this.orderProcessingProperties = orderProcessingProperties;
    }

    /*
        DONE: Seems to be in every controller why not put it in a service
     */


    /*
     * DONE: No need for this one we could use the global one on the principals service class
     */



    /*
        DONE: Seems to be in every controller why not put it in a service, there is already such a method on the service why not use that
     */


    @Override
    public Collection<PrincipalsLoans> listPrincipalLoans() {
        return loansRepository.findAll();
    }

    @Override
    public PrincipalsLoans findLoanById(Long id) {
        return loansRepository.findOne(id);
    }

    @Override
    public void deletePrincipalLoan(Long id) {
        loansRepository.delete(id);
    }

    @Override
    public PrincipalsLoans updatePrincipalsLoan(PrincipalsLoans loan) {
        return loansRepository.save(loan);
    }

    @Override
    public PrincipalsLoans savePrincipalsLoan(PrincipalsLoans loan) {
        return loansRepository.save(loan);
    }

    @Override
    public Collection<PrincipalsLoans> findLoanByPrincipal(Principals principal) {
        return loansRepository.findPrincipalLoansByPrincipal(principal);
    }

    @Override
    public Collection<PrincipalsLoans> findLoanByLender(Principals principal) {
        return loansRepository.findPrincipalLoansByLender(principal);
    }

    @Override
    public Collection<PrincipalsLoans> findAll() {
        return loansRepository.findAll();
    }

    @Override
    public void payLoan() {
        Collection<PrincipalsLoans> loans = loansRepository.findAll();
        for (PrincipalsLoans loan : loans) {
            if (loan.getStatus() == orderProcessingProperties.getPaidStatus()) {

                Date deadline = addPayBackDays(loan.getLoanedapprovedon(), paybackService.findActivePayBackPeriod().getPaybackperiod().intValue());
                loan.setLoanedapprovedon(deadline);
                //compare to today if true do some airtel money transactions
                if (loan.getLoanedapprovedon().compareTo(new Date()) == 0) {
                    //check whether it peer to peer or peer to biz
                    if (loan.getLender() == null) {

                        //peer to biz
                        String status = airtelMoneyTransaction(loan.getPaybackamount(),
                                keProperties.getCashOutTransactionCode(),
                                principalsService.generateMembershipNo(), loan.getPrincipal().getCellphonenumber());
                        if (status.equals("0")) {
                            //transaction successful
                            loan.setStatus(orderProcessingProperties.getPaidStatus());
                            loansRepository.save(loan);
                            // To do send sms ot transaction
                        }

                    } else {
                        //peer to peer
                        //to do add fee
                        String status = airtelMoneyTransaction(loan.getPaybackamount(),
                                keProperties.getCashOutTransactionCode(),
                                principalsService.generateMembershipNo(), loan.getPrincipal().getCellphonenumber());
                        if (status.equals("0")) {
                            String transfer = airtelMoneyTransaction(loan.getPaybackamount(),
                                    keProperties.getCashInTransactionCode(),
                                    principalsService.generateMembershipNo(), loan.getLender().getCellphonenumber());
                            if (transfer.equals("0")) {
                                //transaction successful
                                loan.setStatus(orderProcessingProperties.getPaidStatus());
                                loansRepository.save(loan);
                                // To do send sms ot transaction
                            }

                        }

                    }

                }

            }
        }
    }

    private String airtelMoneyTransaction(Long paybackamount, String cashOutTransactionCode, String s, String cellphonenumber) {
        return null;
    }

    @Override
    public PrincipalsLoans findBySr(ServiceRequests sr) {
        return loansRepository.findByServiceRequest(sr);
    }

    @Override
    public Date addPayBackDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }


    @Override
    public Page<PrincipalsLoans> findAllPaged(Pageable pageable) {
        return loansRepository.findAllPaged(pageable);
    }
}
