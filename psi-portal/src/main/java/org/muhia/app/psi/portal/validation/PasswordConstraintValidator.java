package org.muhia.app.psi.portal.validation;

import com.google.common.base.Joiner;
import edu.vt.middleware.password.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword arg0) {
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {

        LengthRule lengthRule = new LengthRule(8, 16);

/* don't allow whitespace */
        WhitespaceRule whitespaceRule = new WhitespaceRule();

        CharacterCharacteristicsRule charRule = new CharacterCharacteristicsRule();

        charRule.getRules().add(new DigitCharacterRule(1));
        charRule.getRules().add(new NonAlphanumericCharacterRule(1));
        charRule.getRules().add(new UppercaseCharacterRule(1));

        /* don't allow alphabetical sequences */
        AlphabeticalSequenceRule alphaSeqRule = new AlphabeticalSequenceRule();

        /* don't allow numerical sequences of length 3 */
        NumericalSequenceRule numSeqRule = new NumericalSequenceRule(3, true);

        /* don't allow qwerty sequences */
        QwertySequenceRule qwertySeqRule = new QwertySequenceRule();

        /* don't allow 4 repeat characters */
        RepeatCharacterRegexRule repeatRule = new RepeatCharacterRegexRule(4);

        /* group all rules together in a List */
        List<Rule> ruleList = new ArrayList<>();
        ruleList.add(lengthRule);
        ruleList.add(whitespaceRule);
        ruleList.add(charRule);
        ruleList.add(alphaSeqRule);
        ruleList.add(numSeqRule);
        ruleList.add(qwertySeqRule);
        ruleList.add(repeatRule);

        final PasswordValidator validator = new PasswordValidator(ruleList);
        final RuleResult result = validator.validate(new PasswordData(new Password(password)));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(Joiner.on("\n").join(validator.getMessages(result))).addConstraintViolation();
        return false;
    }

}
