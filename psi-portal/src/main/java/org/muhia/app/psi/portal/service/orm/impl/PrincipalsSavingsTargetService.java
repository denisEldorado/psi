/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.muhia.app.psi.portal.service.orm.impl;

import org.muhia.app.psi.config.integ.properties.ObopayKeProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsContributions;
import org.muhia.app.psi.orm.model.PrincipalsSavingsTarget;
import org.muhia.app.psi.orm.model.ServiceRequests;
import org.muhia.app.psi.orm.repo.PrincipalsSavingsTargetsRepository;
import org.muhia.app.psi.portal.service.orm.IContributionMethodsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsContributionsService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsSavingsTargetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mathenge
 */
@Service
public class PrincipalsSavingsTargetService implements IPrincipalsSavingsTargetsService {

    private final IPrincipalsContributionsService contributionService;
    private final PrincipalsSavingsTargetsRepository savingsTargetRepo;
    private final ObopayKeProperties keProperties;
    private final IContributionMethodsService contributionMethodsService;

    @Autowired
    public PrincipalsSavingsTargetService(IPrincipalsContributionsService contributionService, PrincipalsSavingsTargetsRepository savingsTargetRepo, ObopayKeProperties keProperties, IContributionMethodsService contributionMethodsService) {
        this.contributionService = contributionService;
        this.savingsTargetRepo = savingsTargetRepo;
        this.keProperties = keProperties;
        this.contributionMethodsService = contributionMethodsService;
    }

    /*
     * TODO: No need for this one we could use the global one on the principals service class
     */
    private Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }


    private String generateMembershipNumber() {

        String results = "";
        String formatStr = "yyyyMMddHHmmssSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        try {
            results = sdf.format(new Date());
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, results);

        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }

        return results;
    }
    //function to return last elemetn of a collection

    /*
        TODO: Why not just get the element at Collection.size()
     */
    private Object getLastElement(final Collection<PrincipalsContributions> c) {

        final Iterator<PrincipalsContributions> itr = c.iterator();
        Object lastElement = itr.next();
        while (itr.hasNext()) {
            lastElement = itr.next();
        }
        return lastElement;
    }

    @SuppressWarnings("unchecked")
    private String airtelMoneyTransaction(Long amount, String transactionCode, String orderNumber, String phonenumber) {
        return null;
    }

    @Override
    public Collection<PrincipalsSavingsTarget> listAllSavings() {
        return savingsTargetRepo.findAll();
    }

    @Override
    public Collection<PrincipalsSavingsTarget> findByPrincipal(Principals principal) {
        return savingsTargetRepo.findSavingsTargetByPrincipal(principal);
    }

    @Override
    public PrincipalsSavingsTarget findById(Long id) {
        return savingsTargetRepo.findOne(id);
    }

    @Override
    public PrincipalsSavingsTarget createSavingsTarget(PrincipalsSavingsTarget target) {
        return savingsTargetRepo.save(target);
    }

    @Override
    public PrincipalsSavingsTarget updateSavingsTarget(PrincipalsSavingsTarget target) {
        return savingsTargetRepo.save(target);
    }

    @Override
    public void deleteSavingsTarget(Long id) {
        savingsTargetRepo.delete(id);
    }

    @Override
    public void transferSavingsAsPertarget() {
        Collection<PrincipalsSavingsTarget> savingTargets = savingsTargetRepo.findAll();
        savingTargets.forEach((target) -> {
            //getting amount contributed towards target and comparing to target
            Collection<PrincipalsContributions> contributions = target.getSavingsContributions();
            Long total = 0L;
            for (PrincipalsContributions cont : contributions) {
                total = total + cont.getAmount();

            }

            if (total >= target.getTarget()) {
                //target achieved do nothing TODO: So why put it here
            } else {
                Date deductDate = new Date();
                /*
                TODO: Hard-coded, externalise as parameters
                */
                switch (target.getInterval().getInterval()) {
                    case "Daily":
                        //add from date created
                        if (total.equals(Long.valueOf("0"))) {
                            //1st deduction
                            deductDate = addDays(target.getCreatedon(), 1);
                        } else {
                            PrincipalsContributions lastContributionDate = (PrincipalsContributions) getLastElement(contributions);
                            deductDate = addDays(lastContributionDate.getContributedon(), 7);
                        }
                        break;
                    case "Weekly":
                        //add 7 days
                        //add from date created
                        if (total.equals(Long.valueOf("0"))) {
                            //1st deduction
                            deductDate = addDays(target.getCreatedon(), 7);
                        } else {
                            PrincipalsContributions lastContributionDate = (PrincipalsContributions) getLastElement(contributions);
                            deductDate = addDays(lastContributionDate.getContributedon(), 7);
                        }
                        break;
                    case "Monthly":
                        //add 30 days
                        //add from date created
                        if (total.equals(Long.valueOf("0"))) {
                            //1st deduction
                            deductDate = addDays(target.getCreatedon(), 30);
                        } else {
                            PrincipalsContributions lastContributionDate = (PrincipalsContributions) getLastElement(contributions);
                            deductDate = addDays(lastContributionDate.getContributedon(), 7);
                        }
                        break;
                    default:
                        break;
                }
                if (deductDate.compareTo(new Date()) >= 0) {
                    String status = airtelMoneyTransaction((long) target.getAmount(),
                            keProperties.getCashOutTransactionCode(),
                            generateMembershipNumber(), target.getPrincipal().getCellphonenumber());
                    if (status.equals("0")) {
                        //transaction successful
                        PrincipalsContributions saveTransaction = new PrincipalsContributions();
                        saveTransaction.setAmount((long) target.getAmount());
                        saveTransaction.setContributedon(new Date());
                        saveTransaction.setCreatedon(new Date());
                        saveTransaction.setPrincipal(target.getPrincipal());
                        saveTransaction.setStatus(1);
                        saveTransaction.setTarget(target);
                        saveTransaction.setContributionMethod(contributionMethodsService.findByUniqueStatus(5));
                        contributionService.savePrincipalContribution(saveTransaction);
                        // To do send sms ot transaction
                    }

                }
            }
        });
    }

    @Override
    public PrincipalsSavingsTarget findBySr(ServiceRequests sr) {
        return savingsTargetRepo.findByServiceRequest(sr);
    }

}
