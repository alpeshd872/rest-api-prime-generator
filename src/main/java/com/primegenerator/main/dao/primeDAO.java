package com.primegenerator.main.dao;

import java.math.BigDecimal;

/*primeDao interface provide the structure to the primeDaoImpl class it will be implemented by primeDaoImpl for saving the data of requests.
 * */
public interface primeDAO {
    Integer savePrimeData(Integer lowerBound, Integer upperBound, Integer noOfPrimes, BigDecimal timeElapsed,String method);
}
