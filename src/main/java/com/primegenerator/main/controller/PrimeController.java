package com.primegenerator.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.primegenerator.main.service.PrimeService;

@RestController
@RequestMapping("/primeserver")
public class PrimeController {
	public static final String valuesZeroException = "Enter values that are greater than zero.";
	public static final String valuesNotPositiveException = "Enter positive integers only.";
	public static final String upperBoundAlwaysGreaterException = "UpperBound Should be greater than LowerBound.";
	@Autowired
	private PrimeService primeservice;

	@GetMapping("/squareRootInner/{lowerBound}/{upperBound}")
	List<Integer> squareRootInner(@PathVariable Integer lowerBound, @PathVariable Integer upperBound) {
		checkInputForPositive(lowerBound, upperBound);
		return primeservice.squareRootInner(lowerBound, upperBound);
	}

	@GetMapping("/innerLoopTillnbyTwoElement/{lowerBound}/{upperBound}")
	List<Integer> innerLoopTillnbyTwoElement(@PathVariable Integer lowerBound, @PathVariable Integer upperBound) {
		checkInputForPositive(lowerBound, upperBound);
		return primeservice.innerLoopTillnbyTwoElement(lowerBound, upperBound);
	}

	@GetMapping("/nestedFor/{lowerBound}/{upperBound}")
	List<Integer> nestedFor(@PathVariable Integer lowerBound, @PathVariable Integer upperBound) {
		checkInputForPositive(lowerBound, upperBound);
		return primeservice.nestedFor(lowerBound, upperBound);
	}

	public void checkInputForPositive(int lowerBound, int upperBound) {
		if (lowerBound == 0 || upperBound == 0) {
			throw new RuntimeException(valuesZeroException);
		}
		if (lowerBound < 0 || upperBound < 0) {
			throw new RuntimeException(valuesNotPositiveException);
		}
		if (lowerBound > upperBound) {
			throw new RuntimeException(upperBoundAlwaysGreaterException);
		}
	}

}
