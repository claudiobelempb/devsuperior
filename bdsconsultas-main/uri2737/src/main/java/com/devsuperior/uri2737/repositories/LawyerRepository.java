package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.entities.Lawyer;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    String sql = "(SELECT name, customers_number AS customersNumber FROM lawyers WHERE  customers_number = (SELECT MAX (customers_number) FROM lawyers)) " +
            "UNION ALL  " +
            "(SELECT name, customers_number FROM lawyers WHERE customers_number = (SELECT MIN (customers_number) FROM lawyers)) " +
            "UNION ALL " +
            "(SELECT 'Average', round(AVG(customers_number), 0) FROM lawyers)";
    @Query(nativeQuery = true, value = sql)
    List<LawyerMinProjection> sql();
}
