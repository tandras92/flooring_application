package org.sg.flooring.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Target({FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidatorImpl.class)
@Documented
public @interface DateValidator {
    String message() default "{DateValidator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
