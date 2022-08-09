package com.primegenerator.main.service;

import java.util.List;



public interface PrimeService {
	List<Integer> innerLoopTillnElement(Integer lowerBound,Integer upperBound);
	List<Integer> innerLoopTillnbyTwoElement(Integer lowerBound,Integer upperBound);
	List<Integer> nestedFor(Integer lowerBound,Integer upperBound);
}
