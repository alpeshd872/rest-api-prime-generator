package com.primegenerator.main.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "prime_data")
public class PrimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer loweBound;
    private Integer upperBound;
    private Timestamp timeStamp;
    private BigDecimal timeElapsed;
    private String selectedMethod;
    private Integer noOfPrimes;

    public PrimeModel() {

    }

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
