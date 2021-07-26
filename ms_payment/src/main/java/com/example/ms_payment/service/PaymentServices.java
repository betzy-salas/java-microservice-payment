package com.example.ms_payment.service;
import org.springframework.stereotype.Service;

import com.example.ms_payment.domain.PaymentData;
import com.example.ms_payment.interfaces.IPayment;
import com.example.ms_payment.interfaces.IPaymentMethods;

@Service
public class PaymentServices implements IPayment, IPaymentMethods{
	
	static final int amountMonths = 12;

	@Override
	public double payment(PaymentData paymentParameters) {
		// TODO Auto-generated method stub
		return paymentResult(paymentParameters.getDownPayment(), paymentParameters.getPurchasePrice(), paymentParameters.getAnnualInterest(), paymentParameters.getLengthLoan());
	}

	@Override
	public double paymentResult(double downPayment, double purchasePrice, double anualInterest, int lengthLoan) {
		// TODO Auto-generated method stub
		return paymentCalculated(downPayment,purchasePrice, anualInterest, lengthLoan);
	}
	
	@Override
	public double paymentCalculated(double downPayment, double purchasePrice, double anualInterest, int lengthLoan) {
		// TODO Auto-generated method stub
		double calculatedRate= calculateRate(anualInterest);
		double calculateBase = calculatedBase (calculatedRate, lengthLoan);
		return (purchasePrice - downPayment)*((calculatedRate * calculateBase)/(calculateBase - 1));
	}
	
	@Override
	public double calculateRate(double anualInterest) {
		// TODO Auto-generated method stub
		return (anualInterest/100)/amountMonths;
	}
	
	@Override
	public double calculatedBase (double calculatedRate, int lengthLoan) {
		// TODO Auto-generated method stub
		int numberPayments = calculateMonths(lengthLoan);
		return  Math.pow((1+calculatedRate), numberPayments);
	}

	@Override
	public int calculateMonths(int lengthLoan) {
		// TODO Auto-generated method stub
		return lengthLoan * amountMonths;
	}
}
