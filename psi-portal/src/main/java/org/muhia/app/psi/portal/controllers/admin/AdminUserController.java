package org.muhia.app.psi.portal.controllers.admin;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.muhia.app.psi.orm.model.Principals;
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
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ngatia on 1/11/17.
 */
@Controller
public class AdminUserController {

    @Autowired
    IPrincipalsService principalsService;

//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(
            value = "/admin/users",
            method= RequestMethod.GET
    )
    public ModelAndView getAdminUsers(Pageable pageable) {

        Page<Principals> principals=principalsService.listPrincipalsByPage(pageable.getPageNumber(),pageable.getPageSize());
        return new ModelAndView("admin/users/list", "users", principals);
    }

    @RequestMapping(
            value = "/admin/activateuser/{id}",
            method= RequestMethod.POST
    )
    public ModelAndView activateUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            Principals principals=principalsService.findPrincipalsById(id);
            principals.setStatus(1);
            principalsService.saveRegisteredPrincipal(principals);
            redirectAttributes.addFlashAttribute("message", "user enabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(
            value = "/admin/activateusercsv",
            method= RequestMethod.POST
    )
    public ModelAndView activateUserFromCSV(@RequestParam("usercsv") MultipartFile csv,
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
                            principals1.setStatus(1);
                            principalsService.saveRegisteredPrincipal(principals1);
                        }
                );
            }

            redirectAttributes.addFlashAttribute("message", "user enabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(
            value = "/admin/deactivateuser/{id}",
            method= RequestMethod.POST
    )
    public ModelAndView deActivateUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try{
            Principals principals=principalsService.findPrincipalsById(id);
            principals.setStatus(0);
            principalsService.saveRegisteredPrincipal(principals);
            redirectAttributes.addFlashAttribute("message", "user Disabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/admin/users");
    }

    @RequestMapping(
            value = "/admin/deactivateusercsv",
            method= RequestMethod.POST
    )
    public ModelAndView deActivateUserFromCSV(@RequestParam("usercsv") MultipartFile csv,
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
                            principals1.setStatus(0);
                            principalsService.saveRegisteredPrincipal(principals1);
                        }
                );
            }
            redirectAttributes.addFlashAttribute("message", "users disabled successfully");
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("error", "An error occurred");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return new ModelAndView("redirect:/admin/users");
    }
}
