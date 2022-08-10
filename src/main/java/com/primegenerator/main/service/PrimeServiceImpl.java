package com.primegenerator.main.service;

import com.primegenerator.main.dao.primeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrimeServiceImpl implements PrimeService{

    public static final String methodOne = "squareRootInner";
    public static final String methodTwo = "innerLoopTillnbyTwoElement";
    public static final String methodThree = "nestedFor";

    @Autowired
    private primeDAO primeDao;
   
    @Override
    public List<Integer> squareRootInner(Integer lowerBound, Integer upperBound) {
    	Integer low = lowerBound;
    	Integer high = upperBound;
    	List<Integer> result = new ArrayList<>();
    	Instant start = Instant.now();
    	while (low < high) {
    		boolean flag = false;
    		int sqrt = (int) Math.sqrt(low) + 1;
    		for (int i = 2; i < sqrt; i++) {
    			if (low % i == 0) {
    				flag = true;
    				
    			}
    		}

    		if (flag == false && low != 0 && low != 1) {
    			result.add(low);
    		}
    		low++;
    	}
    	Instant finish = Instant.now();
       
        Long temp = Duration.between(start,finish).toMillis();
        BigDecimal timeElapsed = new BigDecimal(temp.toString());
        		
        primeDao.savePrimeData(lowerBound,upperBound,result.size(),timeElapsed,methodOne);
        return result;
        
    }

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

    @Override
    public List<Integer> nestedFor(Integer lowerBound, Integer upperBound) {

        List<Integer> result = new ArrayList<>();
        int f;
        Instant start = Instant.now();
        for (int i=lowerBound;i <= upperBound;i++)
        {
            f=0;
            for(int j=1;j<=i;j++)
            {
                if(i%j==0)
                    f++;
            }
            if(f==2) {
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
