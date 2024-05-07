package com.devsuperior.uri2611.repositorios;

import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieAndGenresActiveProjection;
import com.devsuperior.uri2611.response.MovieResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    /*
    SELECT m.id, m.name FROM movies m
    INNER JOIN genres g
    ON m.id_genres = g.id
    WHERE description = 'Action'
    */

    @Query(nativeQuery = true, value = "SELECT m.id, m.name FROM movies m " +
            "    INNER JOIN genres g " +
            "    ON m.id_genres = g.id " +
            "    WHERE UPPER(description) = UPPER(:genreName)")
    List<MovieAndGenresActiveProjection> searchSql(String genreName);

    @Query("SELECT new com.devsuperior.uri2611.response.MovieResponse(obj.id, obj.name) " +
            " FROM Movie obj " +
            " WHERE UPPER(obj.genre.description) = UPPER(:genreName)")
    List<MovieResponse> searchJpql(String genreName);
}
