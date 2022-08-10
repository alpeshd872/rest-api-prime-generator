package com.primegenerator.main.service;

import com.primegenerator.main.dao.primeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
/*Service specify that this class has all the business logic of the API;
 * */
@Service
public class PrimeServiceImpl implements PrimeService{
    /*Variables that are storing method names for request since they are final value will remain unchanged.*/
    public static final String methodOne = "squareRootInner";
    public static final String methodTwo = "innerLoopTillnbyTwoElement";
    public static final String methodThree = "nestedFor";
/*Creating object of primeDao since will need it to store the value in database autowired will map the values to the methods*/
    @Autowired
    private primeDAO primeDao;
  //A number n is not a prime, if it can be factored into two factors a & b:
 // n = a * b

 /*Now a and b can't be both greater than the square root of n, since
   then the product a * b would be greater than sqrt(n) * sqrt(n) = n.
   So in any factorization of n, at least one of the factors must be
   smaller than the square root of n, and if we can't find any factors
   less than or equal to the square root, n must be a prime.
  */
    @Override
    public List<Integer> squareRootInner(Integer lowerBound, Integer upperBound) {
    	Integer low = lowerBound;
    	Integer high = upperBound;
    	List<Integer> result = new ArrayList<>(); //It will store the prime number and will be returned at the end of function
    	Instant start = Instant.now(); // Current time
    	while (low < high) {  //it will execute the code until the low is not less than high
    		boolean flag = false; //flag will store boolean value which will help us to find primes
    		int sqrt = (int) Math.sqrt(low) + 1; //finding the square root using Math method adding 1 to the value
    		for (int i = 2; i < sqrt; i++) { // loop will run till the value is less than square root of low and check if low is divisble by i and remainder is 0.
    			if (low % i == 0) {//if true flag will set to true and then it is not a prime number
    				flag = true;
    				
    			}
    		}

    		if (flag == false && low != 0 && low != 1) { //if true add low to result 
    			result.add(low);
    		}
    		low++; //increment low
    	}
    	Instant finish = Instant.now(); //Current time
       
        Long temp = Duration.between(start,finish).toMillis(); //Difference between start and end time to find execution time
        BigDecimal timeElapsed = new BigDecimal(temp.toString());
        		
        primeDao.savePrimeData(lowerBound,upperBound,result.size(),timeElapsed,methodOne); //calling savePrimeData using PrimeDao object to save all the data in database
        return result;
        
    }
// this code checks for the all value which are divisible until lower/2 elements
    @Override
    public List<Integer> innerLoopTillnbyTwoElement(Integer lowerBound, Integer upperBound) {
        Integer lower = lowerBound;
        List<Integer> result = new ArrayList<>();
        Instant start = Instant.now();
        while(lower < upperBound) {
            boolean flag = false;
            for(int i = 2 ; i<=lower/2;i++){
                if(lower % i == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag && lower != 0 && lower != 1){
                result.add(lower);
            }
            lower++;
        }
        Instant finish = Instant.now();
        Long temp = Duration.between(start,finish).toMillis();
        BigDecimal timeElapsed = new BigDecimal(temp.toString());
        primeDao.savePrimeData(lowerBound,upperBound,result.size(),timeElapsed,methodTwo);
        return result;
    }
/*The code checks if the factor of number is 1 and number itself if the factor== 2 then it is prime.
 * if not then it is not a prime number
 * */
    @Override
    public List<Integer> nestedFor(Integer lowerBound, Integer upperBound) {

        List<Integer> result = new ArrayList<>();
        int factor;
        Instant start = Instant.now();
        for (int i=lowerBound;i <= upperBound;i++)
        {
          factor=0;
            for(int j=1;j<=i;j++)
            {
                if(i%j==0) //if value of is divisble by j then factor = factor + 1
                    factor++;
            }
            if(factor==2) { //if value of of factor is 2 then only add that number to result list
                result.add(i);
            }
        }
        Instant finish = Instant.now();
        Long temp = Duration.between(start,finish).toMillis();
        BigDecimal timeElapsed = new BigDecimal(temp.toString());
        primeDao.savePrimeData(lowerBound,upperBound,result.size(),timeElapsed,methodThree);
        return result;
    }
}
