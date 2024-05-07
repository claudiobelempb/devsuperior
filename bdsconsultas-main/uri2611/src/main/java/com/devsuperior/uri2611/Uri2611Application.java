package com.devsuperior.uri2611;

import com.devsuperior.uri2611.mappers.MovieMapper;
import com.devsuperior.uri2611.projections.MovieAndGenresActiveProjection;
import com.devsuperior.uri2611.repositorios.MovieRepository;
import com.devsuperior.uri2611.response.MovieResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

    private final MovieRepository movieRepository;

    public Uri2611Application(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Uri2611Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<MovieAndGenresActiveProjection> listSql = movieRepository.searchSql("action");
        System.out.println("\nResult => SQL Raiz");
        for (MovieResponse obj : MovieMapper.toResponseSql(listSql)) {
            System.out.println(obj);
        }

        System.out.println("\n");
        List<MovieResponse> listJpql = movieRepository.searchJpql("action");
        System.out.println("\nResult => JPQL");
        for (MovieResponse obj : MovieMapper.toResponseJpql(listJpql)) {
            System.out.println(obj);
        }
    }
}
