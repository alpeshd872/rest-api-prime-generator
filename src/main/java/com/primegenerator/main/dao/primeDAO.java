package com.primegenerator.main.dao;

import java.math.BigDecimal;

public interface primeDAO {
    Integer savePrimeData(Integer lowerBound, Integer upperBound, Integer noOfPrimes, BigDecimal timeElapsed,String method);
}
