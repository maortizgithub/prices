package com.challenge.prices.application.domain.services;

import com.challenge.prices.application.domain.model.Price;

import java.util.Date;
import java.util.List;

public interface PriceService {

    List<Price> findAll();

    List<Price> findPrices(int brandId, long priceId, Date date);
}
