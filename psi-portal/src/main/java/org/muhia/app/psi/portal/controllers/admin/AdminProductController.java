package org.muhia.app.psi.portal.controllers.admin;

import org.muhia.app.psi.portal.service.orm.IProductMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ngatia on 1/11/17.
 */
@Controller
public class AdminProductController {

    @Autowired
    IProductMasterService productService;


//    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(
            value = "/admin/products",
            method= RequestMethod.GET
    )
    public ModelAndView getAdminProducts(){
        return new ModelAndView("admin/products/list", "products", productService.getAll());
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(
            value = "/admin/products/{id}",
            method= RequestMethod.GET
    )
    public ModelAndView getAdminProduct(@PathVariable("id") Long id){
        return new ModelAndView("admin/products/view", "product", productService.get(id));
    }
}
