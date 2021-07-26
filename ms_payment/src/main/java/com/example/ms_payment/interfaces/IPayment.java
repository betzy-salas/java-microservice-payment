package com.example.ms_payment.interfaces;

import com.example.ms_payment.domain.PaymentData;

public interface IPayment {
	public double payment(PaymentData paymentParameters);	
	public double paymentResult(double downPayment, double purchasePrice, double anualInterest, int lengthLoan);
}
