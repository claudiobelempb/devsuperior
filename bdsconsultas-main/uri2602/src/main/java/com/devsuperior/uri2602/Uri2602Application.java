package com.devsuperior.uri2602;

import com.devsuperior.uri2602.mappers.CustomerMapper;
import com.devsuperior.uri2602.projections.CustomerProjection;
import com.devsuperior.uri2602.reponses.CustomerResponse;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public Uri2602Application(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Uri2602Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<CustomerProjection> listSql = customerRepository.customerNameProjectionSql("rs");
        System.out.println("\nResult => SQL Raiz");
        for (CustomerResponse obj : CustomerMapper.toCustomerResponseSql(listSql)) {
            System.out.println(obj);
        }

        System.out.println("\n");
        List<CustomerResponse> listJpql = customerRepository.customerNameProjectionJpql("rs");
        System.out.println("\nResult => JPQL");
        for (CustomerResponse obj : CustomerMapper.toCustomerResponseJpql(listJpql)) {
            System.out.println(obj);
        }
    }
}
