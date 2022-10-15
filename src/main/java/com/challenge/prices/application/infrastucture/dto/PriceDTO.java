package com.challenge.prices.application.infrastucture.dto;

import com.challenge.prices.application.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PriceDTO {

    private int brandId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN)
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN)
    private Date endDate;
    private int priceList;
    private Long productId;
    private int priority;
    private BigDecimal price;
    @JsonProperty("currency")
    private String curr;
}
