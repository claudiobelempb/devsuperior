package com.devsuperior.uri2611.mappers;

import com.devsuperior.uri2611.projections.MovieAndGenresActiveProjection;
import com.devsuperior.uri2611.response.MovieResponse;

import java.util.List;
import java.util.stream.Collectors;

public final class MovieMapper {
    public static List<MovieResponse> toResponseSql(List<MovieAndGenresActiveProjection> projections) {
        return projections.stream().map(r -> new MovieResponse(r.getId(), r.getName())).collect(Collectors.toList());
    }

    public static List<MovieResponse> toResponseJpql(List<MovieResponse> responses) {
        return responses.stream().map(r -> new MovieResponse(r.id(), r.name())).collect(Collectors.toList());
    }
}
