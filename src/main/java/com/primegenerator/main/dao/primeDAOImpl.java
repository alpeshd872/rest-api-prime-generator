package com.primegenerator.main.dao;

import com.primegenerator.main.model.PrimeModel;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Repository
@Transactional
public class primeDAOImpl implements primeDAO{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Integer savePrimeData(Integer lowerBound, Integer upperBound, Integer noOfPrimes, BigDecimal timeElapsed, String method) {

        PrimeModel primeModel = new PrimeModel(lowerBound,upperBound, Timestamp.from(Instant.now()),timeElapsed,method,noOfPrimes);
        entityManager.persist(primeModel);

        return primeModel.getId();
    }
}
