package com.devsuperior.uri2990.mapper;

import com.devsuperior.uri2990.dto.EmpregadoDeptResponse;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;

import java.util.List;
import java.util.stream.Collectors;

public final class EmpregadoMapper {
    public static List<EmpregadoDeptResponse> toResponseSql(List<EmpregadoDeptProjection> projections) {
        return projections.stream().map(r -> new EmpregadoDeptResponse(r.getCpf(), r.getEnome(), r.getDnome())).collect(Collectors.toList());
    }

    public static List<EmpregadoDeptResponse> toResponseJpql(List<EmpregadoDeptResponse> responses) {
        return responses.stream().map(r -> new EmpregadoDeptResponse(r.cpf(), r.enome(), r.dnome())).collect(Collectors.toList());
    }
}
