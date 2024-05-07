package com.devsuperior.uri2609;

import com.devsuperior.uri2609.mappers.CategoryMapper;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.response.CategorySumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {
	private final CategoryRepository categoryRepository;

	@Autowired
	private CategoryRepository repository;

	public Uri2609Application(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<CategorySumProjection> listSql = categoryRepository.searchSql();
		System.out.println("\nResult => SQL Raiz");
		for (CategorySumResponse obj : CategoryMapper.toResponseSql(listSql)) {
			System.out.println(obj);
		}

		System.out.println("\n");
		List<CategorySumResponse> listJpql = categoryRepository.searchJpql();
		System.out.println("\nResult => JPQL");
		for (CategorySumResponse obj : CategoryMapper.toResponseJpql(listJpql)) {
			System.out.println(obj);
		}
	}
}
