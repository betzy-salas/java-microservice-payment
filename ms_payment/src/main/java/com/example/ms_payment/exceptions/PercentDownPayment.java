package com.example.ms_payment.exceptions;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.ms_payment.validation.PercentDownPaymentValidator;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;

@Constraint(validatedBy = PercentDownPaymentValidator.class)
@Target({ElementType.TYPE })
@Retention(RUNTIME)
@Documented
public @interface PercentDownPayment {

    String message() default "DownPayment cannot be higher than 10% of the property purchase prices";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
    
