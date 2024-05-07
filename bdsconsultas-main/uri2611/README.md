# uri-2611 JOIN SIMPLIS
### Filmes de Ação
<sub>Uma Vídeo locadora contratou seus serviços para catalogar os filmes dela. Eles precisam que você selecione o código e o nome dos filmes cuja descrição do gênero seja 'Action'.</sub>
```
SELECT movies.id, movies.name FROM movies
INNER JOIN genres
ON movies.id_genres = genres.id
WHERE UPPER(genres.description) = UPPER('action')

SQL RAIZ
@Query(nativeQuery = true, value = "SELECT m.id, m.name FROM movies m " +
        "    INNER JOIN genres g " +
        "    ON m.id_genres = g.id " +
        "    WHERE UPPER(description) = UPPER(:genreName)")
List<MovieAndGenresActiveProjection> searchSql(String genreName);

JPQL
@Query("SELECT new com.devsuperior.uri2611.response.MovieResponse(obj.id, obj.name) " +
        " FROM Movie obj " +
        " WHERE UPPER(obj.genre.description) = UPPER(:genreName)")
List<MovieResponse> searchJpql(String genreName);
```
