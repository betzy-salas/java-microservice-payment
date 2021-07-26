package com.example.ms_payment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ms_payment.domain.PaymentData;
import com.example.ms_payment.service.PaymentServices;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentServices paymentService;

	@PostMapping("/v1/monthlyPayment")
	private @ResponseBody ResponseEntity<Object> payment(@Valid @RequestBody PaymentData paymentParameters){
		paymentParameters.setMontlyPayment(paymentService.payment(paymentParameters));
		return ResponseEntity.status(HttpStatus.OK).body(paymentParameters);
	}
	
	@GetMapping("/")
    public @ResponseBody ResponseEntity<String> healthCheckResponse() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nothing here, used for health check. Try /v1/monthlyPayment instead.");
    }
}
