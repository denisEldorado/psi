package org.muhia.app.psi.portal.controllers.admin;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.muhia.app.psi.orm.model.Principals;
import org.muhia.app.psi.orm.model.PrincipalsLoans;
import org.muhia.app.psi.portal.service.orm.IPrincipalsLoansService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ngatia on 1/26/17.
 */

@Controller
public class AdminLoanController {


    @Autowired
    IPrincipalsLoansService loansService;

    @Autowired
    IPrincipalsService principalsService;

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(
            value = "/admin/loans",
            method= RequestMethod.GET
    )
    public ModelAndView getAdminLoans(Pageable pageable) {
        Page<PrincipalsLoans> principalsLoans=loansService.findAllPaged(pageable);
        return new ModelAndView("admin/loans/list", "loans", principalsLoans);
    }

    @RequestMapping(
            value = "/admin/activateloan/{id}",
            method= RequestMethod.POST
    )
    public ModelAndView activateLoan(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            PrincipalsLoans principalsLoans=loansService.findLoanById(id);
            principalsLoans.setStatus(1);
            loansService.savePrincipalsLoan(principalsLoans);
            redirectAttributes.addFlashAttribute("message", "Loan enabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("admin/loans/list");
    }


    @RequestMapping(
            value = "/admin/activateloancsv",
            method= RequestMethod.POST
    )
    public ModelAndView activateLoanFromCSV(@RequestParam("loancsv") MultipartFile csv,
                                            RedirectAttributes redirectAttributes) {
        try{
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
            MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new InputStreamReader(csv.getInputStream()));
            while (it.hasNext()) {
                Map<String, String> rowAsMap = it.next();
                Optional<Principals> principals=principalsService.findUserByPhone(rowAsMap.get("phonenumber"));
                principals.ifPresent(
                        principals1 -> {
                            Collection<PrincipalsLoans> principalsLoans=loansService.findLoanByPrincipal(principals1);
                            for(PrincipalsLoans loan:principalsLoans){
                                loan.setStatus(1);
                                loansService.savePrincipalsLoan(loan);
                            }
                        }
                );
            }

            redirectAttributes.addFlashAttribute("message", "loans enabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("admin/loans/list");
    }


    @RequestMapping(
            value = "/admin/deaactivateloan/{id}",
            method= RequestMethod.POST
    )
    public ModelAndView deActivateLoan(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            PrincipalsLoans principalsLoans=loansService.findLoanById(id);
            principalsLoans.setStatus(0);
            loansService.savePrincipalsLoan(principalsLoans);
            redirectAttributes.addFlashAttribute("message", "Loan Disabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("admin/loans/list");
    }


    @RequestMapping(
            value = "/admin/deactivateloancsv",
            method= RequestMethod.POST
    )
    public ModelAndView deActivateLoanFromCSV(@RequestParam("loancsv") MultipartFile csv,
                                            RedirectAttributes redirectAttributes) {
        try{
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine
            MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class)
                    .with(schema)
                    .readValues(new InputStreamReader(csv.getInputStream()));
            while (it.hasNext()) {
                Map<String, String> rowAsMap = it.next();
                Optional<Principals> principals=principalsService.findUserByPhone(rowAsMap.get("phonenumber"));
                principals.ifPresent(
                        principals1 -> {
                            Collection<PrincipalsLoans> principalsLoans=loansService.findLoanByPrincipal(principals1);
                            for(PrincipalsLoans loan:principalsLoans){
                                loan.setStatus(0);
                                loansService.savePrincipalsLoan(loan);
                            }
                        }
                );
            }

            redirectAttributes.addFlashAttribute("message", "loans Disabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("admin/loans/list");
    }
}
