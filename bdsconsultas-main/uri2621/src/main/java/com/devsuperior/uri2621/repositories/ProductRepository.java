package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductNameProjection;
import com.devsuperior.uri2621.responses.ProductNameResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
        SELECT p.name
        FROM products p
        INNER JOIN providers v
        ON p.id_providers = v.id
        WHERE p.amount BETWEEN 10 AND 20
        AND v.name LIKE UPPER('P%')
    */

    String sql = "SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers " +
            "ON products.id_providers = providers.id " +
            "WHERE products.amount BETWEEN :min AND :max " +
            "AND UPPER(providers.name) LIKE CONCAT(UPPER(:name), '%')";

    @Query(nativeQuery = true, value = sql)
    List<ProductNameProjection> searchSql(Integer min, Integer max, String name);

    @Query("SELECT new com.devsuperior.uri2621.responses.ProductNameResponse(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.amount BETWEEN :min AND :max " +
            "AND UPPER(obj.provider.name) LIKE CONCAT(UPPER(:name), '%')"
    )
    List<ProductNameResponse> searchJpql(Integer min, Integer max, String name);
}
