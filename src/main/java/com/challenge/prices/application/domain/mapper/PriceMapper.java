package com.challenge.prices.application.domain.mapper;

import com.challenge.prices.application.domain.model.Price;
import com.challenge.prices.application.infrastucture.dto.PriceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper extends ApplicationMapper<PriceDTO, Price> {

    @Override
    PriceDTO toDto(Price entity);

    @Override
    List<PriceDTO> toDto(List<Price> entity);

    @Override
    Price toEntity(PriceDTO dto);

    @Override
    List<Price> toEntity(List<PriceDTO> dto);

}
