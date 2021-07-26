package com.example.ms_payment.exceptions;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.ms_payment.validation.LengthLoanValidator;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

@Constraint(validatedBy = LengthLoanValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Documented
public @interface LengthLoanValidation {

    String message() default "The Number of years must be between 1 and 30";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
    
