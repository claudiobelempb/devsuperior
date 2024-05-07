package com.devsuperior.uri2602.mappers;

import com.devsuperior.uri2602.projections.CustomerProjection;
import com.devsuperior.uri2602.reponses.CustomerResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class CustomerMapper {
    public static List<CustomerResponse> toCustomerResponseSql(List<CustomerProjection> projections) {
        return projections.stream().map(r -> new CustomerResponse(r.getName())).collect(Collectors.toList());
    }

    public static List<CustomerResponse> toCustomerResponseJpql(List<CustomerResponse> responses) {
        return responses.stream().map(r -> new CustomerResponse(r.name())).collect(Collectors.toList());
    }
}
