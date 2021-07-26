package com.example.ms_payment.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.example.ms_payment.exceptions.LengthLoanValidation;
import com.example.ms_payment.exceptions.PercentDownPayment;

@PercentDownPayment
public class PaymentData {
	
	@NotNull 
	@Positive(message = "Down Payment should be positive number")
	double downPayment;
	
	@NotNull 
	@Positive(message = "Purchase Price should be positive number")
	private double purchasePrice;
	
	@NotNull 
	@Positive(message = "Annual Interest should be positive number")
	private double annualInterest;
	
	@NotNull
	@Positive(message = "Number of year should be positive number")
	@LengthLoanValidation
	//@Min(value = 1, message = "Number of years should not be less than 1")
    //@Max(value = 30, message = "Number of years  should not be greater than 30")
	private int lengthLoan;
	
	private double montlyPayment;
	
	public double getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public double getAnnualInterest() {
		return annualInterest;
	}
	public void setAnnualInterest(double annualInterest) {
		this.annualInterest = annualInterest;
	}
	public int getLengthLoan() {
		return lengthLoan;
	}
	public void setLengthLoan(int lengthLoan) {
		this.lengthLoan = lengthLoan;
	}
	public double getMontlyPayment() {
		return montlyPayment;
	}
	public void setMontlyPayment(double montlyPayment) {
		this.montlyPayment = montlyPayment;
	}
		
}
