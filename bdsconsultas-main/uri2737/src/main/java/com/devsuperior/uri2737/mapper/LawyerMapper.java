package com.devsuperior.uri2737.mapper;

import com.devsuperior.uri2737.dto.LawyerMinResponse;
import com.devsuperior.uri2737.projections.LawyerMinProjection;

import java.util.List;
import java.util.stream.Collectors;

public final class LawyerMapper {
    public static List<LawyerMinResponse> toResponseSql(List<LawyerMinProjection> projections) {
        return projections.stream().map(r -> new LawyerMinResponse(r.getName(), r.getCustomersNumber())).collect(Collectors.toList());
    }

    public static List<LawyerMinResponse> toResponseJpql(List<LawyerMinResponse> responses) {
        return responses.stream().map(r -> new LawyerMinResponse(r.name(), r.customersNumber())).collect(Collectors.toList());
    }
}
