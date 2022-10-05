package com.challenge.prices.application.domain.mapper;

import java.util.List;

public interface ApplicationMapper<T, U> {

    T toDto(U entity);

    List<T> toDto(List<U> entity);

    U toEntity(T dto);

    List<U> toEntity(List<T> dto);
}
