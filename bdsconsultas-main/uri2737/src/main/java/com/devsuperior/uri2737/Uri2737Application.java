package com.devsuperior.uri2737;

import com.devsuperior.uri2737.dto.LawyerMinResponse;
import com.devsuperior.uri2737.mapper.LawyerMapper;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.repositories.LawyerRepository;

import java.util.List;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	private final LawyerRepository lawyerRepository;

	public Uri2737Application(LawyerRepository lawyerRepository) {
		this.lawyerRepository = lawyerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<LawyerMinProjection> listSql = lawyerRepository.sql();
		System.out.println("\nResult => SQL Raiz");
		for (LawyerMinResponse obj : LawyerMapper.toResponseSql(listSql)) {
			System.out.println(obj);
		}
//
//		System.out.println("\n");
//		List<LawyerMinResponse> listJpql = lawyerRepository.Jpql("rs");
//		System.out.println("\nResult => JPQL");
//		for (LawyerMinResponse obj : LawyerMapper.toResponseJpql(listJpql)) {
//			System.out.println(obj);
//		}

	}
}
