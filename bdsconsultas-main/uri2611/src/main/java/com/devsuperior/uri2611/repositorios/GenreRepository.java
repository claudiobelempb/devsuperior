package com.devsuperior.uri2611.repositorios;

import com.devsuperior.uri2611.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
