package com.primegenerator.main.dao;

import com.primegenerator.main.model.PrimeModel;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
/* Repository annotation specifies that this class provides the mechanism for saving the data inside the databse.This for Dao classes.
 * */
@Repository
/*Transactional will create proxy for the class primeDaoImpl.This proxy will allow the framework to inject logic before and after running the method.
 * This is for starting and committing the transaction.
 * */
@Transactional
public class primeDAOImpl implements primeDAO{
    /*Persistence context provides the cache for the entity instances so the entity manager can persist that data into database.
     * */
	@PersistenceContext
	/*Entity Manager api is part of hibernate and it is used for creating and removing persistence entity instances.
	 * */
    private EntityManager entityManager;
    @Override
    public Integer savePrimeData(Integer lowerBound, Integer upperBound, Integer noOfPrimes, BigDecimal timeElapsed, String method) {
/*Creating an object of prime model and entity manager will persist(add) the entity of primemodel object to database.
 * 
 * */
        PrimeModel primeModel = new PrimeModel(lowerBound,upperBound, Timestamp.from(Instant.now()),timeElapsed,method,noOfPrimes);
        entityManager.persist(primeModel);

        return primeModel.getId();
    }
}
