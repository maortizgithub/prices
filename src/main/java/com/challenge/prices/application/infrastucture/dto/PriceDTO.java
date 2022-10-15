package com.challenge.prices.application.infrastucture.dto;

import com.challenge.prices.application.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PriceDTO {

    // identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.
    private Long productId;
    private int brandId;
    private int priceList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN)
    private Date startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN)
    private Date endDate;
    private BigDecimal price;
}
