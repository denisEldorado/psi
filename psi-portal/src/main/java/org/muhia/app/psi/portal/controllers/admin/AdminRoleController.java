package org.muhia.app.psi.portal.controllers.admin;

import org.muhia.app.psi.orm.model.Priviledges;
import org.muhia.app.psi.orm.model.RolePrivileges;
import org.muhia.app.psi.orm.model.Roles;
import org.muhia.app.psi.portal.service.orm.IPriviledgeService;
import org.muhia.app.psi.portal.service.orm.IRolePrivilegesService;
import org.muhia.app.psi.portal.service.orm.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
  Copyright 2015-2017 the original author or authors.
  <p>
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at
  <p>
  http://www.apache.org/licenses/LICENSE-2.0
  <p>
  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.

*/

/*
    Created by ngatia
    Project: psi
    Package: ${PACKAGE_NAME}
    Generated on: 1/17/17.
*/

@Controller
public class AdminRoleController {

    private final IRolesService rolesService;

    private final IPriviledgeService privilegeService;

    private final IRolePrivilegesService rolePrivilegesService;

    @Autowired
    public AdminRoleController(IRolesService rolesService, IPriviledgeService privilegeService, IRolePrivilegesService rolePrivilegesService) {
        this.rolesService = rolesService;
        this.privilegeService = privilegeService;
        this.rolePrivilegesService = rolePrivilegesService;
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/roles", method = RequestMethod.GET)
    public ModelAndView getAdminRoles() {
        Map<String, Object> model = new HashMap<>();
        model.put("roles", rolesService.getAll());
        model.put("privileges", privilegeService.getAll());
        return new ModelAndView("admin/role/role", model);
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin/roles", method = RequestMethod.POST)
    public ModelAndView saveRole(@RequestParam("rolename") String rolename, RedirectAttributes redirectAttributes, Principal principal) {
        try {
            Roles roles = new Roles();
            roles.setRolename(rolename);
            roles.setCreatedby(principal.getName());
            roles.setCreatedon(new Date());
            roles.setStatus(1);
            rolesService.save(roles);
            redirectAttributes.addFlashAttribute("message", "Role saved succesffuly");
            return new ModelAndView("redirect:/admin/roles");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occured");
            return new ModelAndView("redirect:/admin/roles");
        }
    }


    @RequestMapping(value = "/admin/privileges", method = RequestMethod.POST)
    public ModelAndView savePrivilege(@RequestParam("privname") String privname, RedirectAttributes redirectAttributes, Principal principal) {
        try {

            Priviledges priviledges = new Priviledges();
            priviledges.setPriviledge(privname);
            priviledges.setCreatedby(principal.getName());
            priviledges.setCreatedon(new Date());
            priviledges.setStatus(1);
            privilegeService.save(priviledges);
            redirectAttributes.addFlashAttribute("message", "Priviledge saved succesffuly");
            return new ModelAndView("redirect:/admin/roles");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occured");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ModelAndView("redirect:/admin/roles");
        }
    }


    @RequestMapping(value = "/admin/roleprivileges", method = RequestMethod.POST)
    public ModelAndView saveRolePriviledge(@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes, Principal principal) {
        /*
        TODO: What is the use of the principal parameter?
         */
        try {
            List<Long> roleIds = new ArrayList<>();
            List<Long> privIds = new ArrayList<>();
            for (Map.Entry<String, String> entry : allParams.entrySet()) {
//                Logger.getLogger(this.getClass().getName()).log(Level.INFO,"Hop unafika hapa");

                if (entry.getKey().substring(0, 4).equals("role")) {
                    roleIds.add(Long.parseLong(entry.getValue()));
                } else if (entry.getKey().substring(0, 4).equals("priv")) {
                    privIds.add(Long.parseLong(entry.getValue()));
                }
            }

            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("roleIds sub {0} ", roleIds.toString()));
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, MessageFormat.format("privIds sub {0} ", privIds.toString()));
            for (Long roleId : roleIds) {
                for (Long privId : privIds) {
                    Roles role = rolesService.findOne(roleId);
                    Priviledges priviledges = privilegeService.findOne(privId);
                    RolePrivileges rolePrivileges = new RolePrivileges(1, role, priviledges);
                    rolePrivilegesService.save(rolePrivileges);
                }
            }
            redirectAttributes.addFlashAttribute("message", "Records saved successfully");
            return new ModelAndView("redirect:/admin/roles");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occured");
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ModelAndView("redirect:/admin/roles");
        }

    }


}
