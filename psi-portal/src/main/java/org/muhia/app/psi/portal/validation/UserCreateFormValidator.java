package org.muhia.app.psi.portal.validation;

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

import org.muhia.app.psi.portal.service.mail.IAccessService;
import org.muhia.app.psi.portal.service.orm.IPrincipalsService;
import org.muhia.app.psi.config.message.properties.MessageProperties;
import org.muhia.app.psi.orm.model.Principals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/*
    Created by Kenneth Muhia <muhia@muhia.org> 
    Project: psi
    Package: org.muhia.app.psi.infra.validators
    Date: 03-Jan-17.
*/
@Component
public class UserCreateFormValidator implements Validator {
    @Autowired
    private MessageProperties messageProperties;
    private final IPrincipalsService userService;
    private final IAccessService accessService;

    @Autowired
    public UserCreateFormValidator(IPrincipalsService userService, IAccessService accessService) {
        this.userService = userService;
        this.accessService = accessService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Principals.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Principals form = (Principals) target;
        if (form.getId() == null) {
            validatePasswords(errors, form);
            validateEmail(errors, form);
            validateDomain(errors, form);
            validateUsername(errors, form);
        } else {
            validateUsername(errors, form,form.getId());
        }

    }

    private void validateUsername(Errors errors, Principals form, long userId) {
        Principals user = userService.findByLoginName(form.getLoginName());
        if (user != null) {
            if (user.getId() != userId) {
                errors.reject(messageProperties.getUserExists(), messageProperties.getUserExists());
            }
        }
    }

    private void validateUsername(Errors errors, Principals form) {
        if (userService.findByLoginName(form.getLoginName()) != null) {
            errors.reject(messageProperties.getUserExists(), messageProperties.getUserExists());
        }

    }

    private void validateDomain(Errors errors, Principals form) {
        if (!accessService.isEmailApproved(form.getEmailaddress())) {
            errors.reject(messageProperties.getDomainNotApproved(),
                    messageProperties.getDomainNotApproved());
        }

    }

    private void validateEmail(Errors errors, Principals form) {
        if (userService.findUserByEmail(form.getEmailaddress())!= null) {
            errors.reject(messageProperties.getMailExists(), messageProperties.getMailExists());
        }

    }

    private void validatePasswords(Errors errors, Principals form) {
        if (!form.getCredentials().equals(form.getPasswordsConfirmation())) {
            errors.reject(messageProperties.getNoMatchPassword(), messageProperties.getNoMatchPassword());
        }

    }
}
