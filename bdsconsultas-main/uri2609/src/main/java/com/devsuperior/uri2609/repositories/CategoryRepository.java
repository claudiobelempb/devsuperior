package com.devsuperior.uri2609.repositories;

import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.response.CategorySumResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2609.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /*
    SELECT categories.name, SUM(products.amount) FROM categories
    INNER JOIN products
    ON products.id_categories = categories.id
    GROUP BY categories.name
    */


    String sql = "SELECT categories.name, SUM(products.amount) " +
            "FROM categories " +
            "INNER JOIN products " +
            "ON products.id_categories = categories.id " +
            "GROUP BY categories.name";
    @Query(nativeQuery = true, value = sql)
    List<CategorySumProjection> searchSql();

    String jpql = "SELECT new com.devsuperior.uri2609.response.CategorySumResponse(obj.category.name, SUM(obj.amount)) " +
            "FROM Product obj " +
            "GROUP BY obj.category.name";
    @Query(jpql)
    List<CategorySumResponse> searchJpql();
}
