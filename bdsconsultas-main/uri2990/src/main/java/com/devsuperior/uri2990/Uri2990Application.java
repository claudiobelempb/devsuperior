package com.devsuperior.uri2990;

import com.devsuperior.uri2990.dto.EmpregadoDeptResponse;
import com.devsuperior.uri2990.mapper.EmpregadoMapper;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

    @Autowired
    private EmpregadoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Uri2990Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<EmpregadoDeptProjection> listSql = repository.sql();
        System.out.println("\nResult => SQL Raiz");
        for (EmpregadoDeptResponse obj : EmpregadoMapper.toResponseSql(listSql)) {
            System.out.println(obj);
        }

        System.out.println("\n");
        List<EmpregadoDeptResponse> listJpql = repository.jpql();
        System.out.println("\nResult => JPQL");
        for (EmpregadoDeptResponse obj : EmpregadoMapper.toResponseJpql(listJpql)) {
            System.out.println(obj);
        }
    }
}
