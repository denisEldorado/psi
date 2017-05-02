package org.muhia.app.psi.portal.validation;

import org.muhia.app.psi.orm.model.Principals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        final Principals user = (Principals) value;
        return user.getCredentials().equals(user.getPasswordsConfirmation());
    }

    

}
