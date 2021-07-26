package com.example.ms_payment.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.ms_payment.exceptions.LengthLoanValidation;

public class LengthLoanValidator implements
        ConstraintValidator<LengthLoanValidation, Integer> {

    @Override
    public void initialize(LengthLoanValidation constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
      
    	return ((value>=1 && value <=30 )? true : false);
    	
    }
}