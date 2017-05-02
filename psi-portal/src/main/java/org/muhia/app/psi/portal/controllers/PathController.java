package org.muhia.app.psi.portal.controllers;

import java.util.HashMap;
import java.util.Map;
import org.muhia.app.psi.portal.service.orm.IDefineSecurityQuestionsService;
import org.muhia.app.psi.portal.service.orm.ITitlesService;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PathController {

    //

    @Autowired
    private IDefineSecurityQuestionsService securityQuestionsService;
    @Autowired
    private ITitlesService titlesService;
    
    
    @RequestMapping("/index")
    public ModelAndView forgotPasswordForm() {
        final Map<String, Object> model = new HashMap<>();
        model.put("user", new Principals());
        model.put("titles", titlesService.findTitlesByStatusActive(1));
        model.put("questions", securityQuestionsService.listActiveDefineSecurityQuestions(1));
        return new ModelAndView("landingPage",model);
    }


}
