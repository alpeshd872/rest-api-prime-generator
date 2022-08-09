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
@Autowired
private PrimeService primeservice;
@GetMapping("/innerLoopTillnElement/{lowerBound}/{upperBound}")
List<Integer> innerLoopTillnElement(@PathVariable Integer lowerBound,@PathVariable Integer upperBound){
	return primeservice.innerLoopTillnElement(lowerBound, upperBound);
}
@GetMapping("/innerLoopTillnbyTwoElement/{lowerBound}/{upperBound}")
List<Integer> innerLoopTillnbyTwoElement(@PathVariable  Integer lowerBound,@PathVariable  Integer upperBound){
	return primeservice.innerLoopTillnbyTwoElement(lowerBound, upperBound);
}
@GetMapping("/nestedFor/{lowerBound}/{upperBound}")
List<Integer> nestedFor(@PathVariable  Integer lowerBound,@PathVariable  Integer upperBound){
	return primeservice.nestedFor(lowerBound, upperBound);
}


}
