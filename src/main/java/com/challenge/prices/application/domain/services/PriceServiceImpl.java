package com.challenge.prices.application.domain.services;

import com.challenge.prices.application.domain.model.Price;
import com.challenge.prices.application.domain.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    @Override
    public List<Price> findAll() {
        return priceRepository.findAll();
    }
}
