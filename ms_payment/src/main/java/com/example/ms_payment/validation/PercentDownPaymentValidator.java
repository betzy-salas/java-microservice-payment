package com.example.ms_payment.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.ms_payment.domain.PaymentData;
import com.example.ms_payment.exceptions.PercentDownPayment;

public class PercentDownPaymentValidator implements
        ConstraintValidator<PercentDownPayment, PaymentData> {

    @Override
    public void initialize(PercentDownPayment constraintAnnotation) {
    }

    @Override
    public boolean isValid(PaymentData paymentData, ConstraintValidatorContext context) {
      
    	double purchasePercent = paymentData.getPurchasePrice() * 0.10;
    	double downPayment = paymentData.getDownPayment();
    	
    	if(purchasePercent >= 0 &&  downPayment >= 0)
    		return (( downPayment <= purchasePercent )? true : false);
    	else
    		return true;
    }
}