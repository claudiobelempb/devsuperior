package com.devsuperior.uri2621;

import com.devsuperior.uri2621.mappers.ProductMapper;
import com.devsuperior.uri2621.projections.ProductNameProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;
import com.devsuperior.uri2621.responses.ProductNameResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

    private final ProductRepository productRepository;

    public Uri2621Application(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Uri2621Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ProductNameProjection> listSql = productRepository.searchSql(10, 20, "p");
        System.out.println("\nResult => SQL Raiz");
        for (ProductNameResponse obj : ProductMapper.toResponseSql(listSql)) {
            System.out.println(obj.name());
        }

        System.out.println("\n");
        List<ProductNameResponse> listJpql = productRepository.searchJpql(10, 20, "P");
        System.out.println("\nResult => JPQL");
        for (ProductNameResponse obj : ProductMapper.toResponseJpql(listJpql)) {
            System.out.println(obj);
        }
    }
}
