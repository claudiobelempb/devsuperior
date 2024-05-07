package com.devsuperior.uri2990.repositories;

import com.devsuperior.uri2990.dto.EmpregadoDeptResponse;
import com.devsuperior.uri2990.entities.Empregado;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

    String sql = "SELECT e.cpf, e.enome, d.dnome " +
            "FROM empregados e " +
            "INNER JOIN departamentos d ON e.dnumero = d.dnumero " +
            "WHERE e.cpf NOT IN ( " +
            "SELECT e.cpf " +
            "FROM empregados e " +
            "INNER JOIN trabalha t ON t.cpf_emp = e.cpf " +
            ") " +
            "ORDER BY e.cpf";

    @Query(nativeQuery = true, value = sql)
    List<EmpregadoDeptProjection> sql();

    String jpql = "SELECT new com.devsuperior.uri2990.dto.EmpregadoDeptResponse(e.cpf, e.enome, e.departamento.dnome) " +
            "FROM Empregado e " +
            "WHERE e.cpf NOT IN ( " +
            "SELECT e.cpf " +
            "FROM Empregado e " +
            "INNER JOIN e.projetosOndeTrabalha " +
            ") " +
            "ORDER BY e.cpf";
    @Query(jpql)
    List<EmpregadoDeptResponse> jpql();
}
