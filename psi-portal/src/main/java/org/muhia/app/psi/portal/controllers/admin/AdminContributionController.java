package org.muhia.app.psi.portal.controllers.admin;

import org.muhia.app.psi.orm.model.PrincipalsContributions;
import org.muhia.app.psi.portal.service.orm.IPrincipalsContributionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ngatia on 1/26/17.
 */
@Controller
public class AdminContributionController {

    @Autowired
    IPrincipalsContributionsService contributionsService;

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/contributions", method = RequestMethod.GET)
    public ModelAndView getAdminContributions(Pageable pageable) {
        Page<PrincipalsContributions> contributions = contributionsService.findAllPaged(pageable);
        return new ModelAndView("admin/contributions/list", "contributions", contributions);
    }
}
