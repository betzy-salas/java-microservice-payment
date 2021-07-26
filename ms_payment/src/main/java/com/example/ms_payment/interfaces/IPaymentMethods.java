package com.example.ms_payment.interfaces;

public interface IPaymentMethods {
	public double calculateRate(double anualInterest);
	public int calculateMonths(int lengthLoan);
	public double calculatedBase (double calculatedRate, int lengthLoan);
	public double paymentCalculated(double downPayment, double purchasePrice, double anualInterest, int lengthLoan);
}
