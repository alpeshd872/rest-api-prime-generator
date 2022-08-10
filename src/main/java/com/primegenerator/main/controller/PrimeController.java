package com.primegenerator.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.primegenerator.main.service.PrimeService;


/*
 * The controller sets the web framework route,
 * connects the service and repository for
 * creating and handling prime numbers 
 *
 */

@RestController
@RequestMapping("/primeserver")
public class PrimeController {
	//Variables that are storing error messages since they are final value will remain unchanged.
	public static final String valuesZeroException = "Enter values that are greater than zero.";
	public static final String valuesNotPositiveException = "Enter positive integers only.";
	public static final String upperBoundAlwaysGreaterException = "UpperBound Should be greater than LowerBound.";
	
	//Connecting the primeservice property to PrimeService Interface so we can use the methods for the method call
	@Autowired
	private PrimeService primeservice;
/* GetMapping helps us to find the specific request handler method for the coming HTTP Request.
 * */
	@GetMapping("/squareRootInner/{lowerBound}/{upperBound}")
	List<Integer> squareRootInner(@PathVariable Integer lowerBound, @PathVariable Integer upperBound) {
/*This method will help us to identify if integer is positive or not.
 * We use this method for each method call since we have to check prime number for every method.
		*/
		checkInputForPositive(lowerBound, upperBound);
		/*returns the list of prime numbers
		 * */
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
		/*First condition will throw an error if the lowerBound or UpperBound is zero
		 * */
		
		if (lowerBound == 0 || upperBound == 0) {
			throw new RuntimeException(valuesZeroException);
		}
		/*Second condition will throw an error if the lowerBound or UpperBound is less than zero
		 * */
		if (lowerBound < 0 || upperBound < 0) {
			throw new RuntimeException(valuesNotPositiveException);
		}
		/*This condition will throw an error if lowerBound is greater than upperBound
		 * */
		if (lowerBound > upperBound) {
			throw new RuntimeException(upperBoundAlwaysGreaterException);
		}
	}

}
