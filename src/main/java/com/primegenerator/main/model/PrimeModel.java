package com.primegenerator.main.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;
/*Entity defines that this class is an entity class and it should be mapped to database
 * */
@Entity
@Table(name = "prime_data")
/*The table annotation allow us to specify the table structure that will be used to persist the entity to database
 * Table annotation have different attributes the name attributes gives the table name inside the database*/

public class PrimeModel {
	/* Id annotation specify that id property is a unique identifier and it is primary key*/
    @Id
    /*Generated value specify the generation strategy for the primary key that we have define*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer loweBound;
    private Integer upperBound;
    private Timestamp timeStamp;
    private BigDecimal timeElapsed;
    private String selectedMethod;
    private Integer noOfPrimes;
 /* No args(Empty) Constructor */
    public PrimeModel() {

    }
/*Parametarized constructor which will store the value on object creation */
    public PrimeModel(Integer loweBound, Integer upperBound, Timestamp timeStamp, BigDecimal executionTime,
                      String selectedMethod, Integer noPrimes) {
        super();
        this.loweBound = loweBound;
        this.upperBound = upperBound;
        this.timeStamp = timeStamp;
        this.timeElapsed = executionTime;
        this.selectedMethod = selectedMethod;
        this.noOfPrimes = noPrimes;
    }
/*Getters and Setters*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoweBound() {
        return loweBound;
    }

    public void setLoweBound(Integer loweBound) {
        this.loweBound = loweBound;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(Integer upperBound) {
        this.upperBound = upperBound;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public BigDecimal getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(BigDecimal timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public String getSelectedMethod() {
        return selectedMethod;
    }

    public void setSelectedMethod(String selectedMethod) {
        this.selectedMethod = selectedMethod;
    }

    public Integer getNoOfPrimes() {
        return noOfPrimes;
    }

    public void setNoOfPrimes(Integer noOfPrimes) {
        this.noOfPrimes = noOfPrimes;
    }

}
