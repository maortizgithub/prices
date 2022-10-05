package com.challenge.prices.application.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@Entity
public class Price {

    @Id
    @GeneratedValue
    private Long id;
    private String brandId;
    private Calendar startDate;
    private Calendar endDate;
    private int priceList;
    private Long productId;
    private int priority;
    private BigDecimal price;
    private String curr;
}
