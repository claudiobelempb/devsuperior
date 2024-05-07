package com.devsuperior.uri2621.mappers;

import com.devsuperior.uri2621.projections.ProductNameProjection;
import com.devsuperior.uri2621.responses.ProductNameResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class ProductMapper {
    public static List<ProductNameResponse> toResponseSql(List<ProductNameProjection> projections) {
        return projections.stream().map(r -> new ProductNameResponse(r.getName())).collect(Collectors.toList());
    }

    public static List<ProductNameResponse> toResponseJpql(List<ProductNameResponse> responses) {
        return responses.stream().map(r -> new ProductNameResponse(r.name())).collect(Collectors.toList());
    }
}
