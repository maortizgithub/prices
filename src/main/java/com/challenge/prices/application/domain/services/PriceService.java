package com.challenge.prices.application.domain.services;

import com.challenge.prices.application.domain.model.Price;

import java.util.List;

public interface PriceService {

    public List<Price> findAll();
}
