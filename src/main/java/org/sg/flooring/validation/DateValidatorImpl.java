package org.sg.flooring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidatorImpl implements ConstraintValidator<DateValidator, LocalDate> {

    @Override
    public void initialize(final DateValidator constraintAnnotation) {

    }

    @Override
    public boolean isValid(final LocalDate value, final ConstraintValidatorContext context) {
        LocalDate date = LocalDate.now();
        return !value.isAfter(date) || value.isBefore(date);
    }
}
