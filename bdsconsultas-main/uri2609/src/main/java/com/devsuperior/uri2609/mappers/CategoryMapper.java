package com.devsuperior.uri2609.mappers;

import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.response.CategorySumResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class CategoryMapper {
    public static List<CategorySumResponse> toResponseSql(List<CategorySumProjection> projections) {
        return projections.stream().map(projection -> new CategorySumResponse(projection.getName(), projection.getSum())).collect(Collectors.toList());
    }

    public static List<CategorySumResponse> toResponseJpql(List<CategorySumResponse> responses) {
        return responses.stream().map(response -> new CategorySumResponse(response.name(), response.sum())).collect(Collectors.toList());
    }
}
