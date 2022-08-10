package com.primegenerator.main.service;

import java.util.List;


/*Creating an interface for primeservice implementation*/
public interface PrimeService {
	List<Integer> squareRootInner(Integer lowerBound,Integer upperBound);
	List<Integer> innerLoopTillnbyTwoElement(Integer lowerBound,Integer upperBound);
	List<Integer> nestedFor(Integer lowerBound,Integer upperBound);
}
