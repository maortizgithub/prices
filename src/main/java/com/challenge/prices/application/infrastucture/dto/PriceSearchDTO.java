package com.challenge.prices.application.infrastucture.dto;

import com.challenge.prices.application.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PriceSearchDTO {
    int brandId;
    Long productId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_PATTERN)
    Date date;
}
