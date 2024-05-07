package com.devsuperior.aula.service;

import com.devsuperior.aula.dto.DepartmentCustomDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.mapper.DepartamentMapper;
import com.devsuperior.aula.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartamentCreateService {
    private final DepartmentRepository departamentRepository;

    public DepartamentCreateService(DepartmentRepository departamentRepository) {
        this.departamentRepository = departamentRepository;
    }

    public DepartmentCustomDTO execute(DepartmentCustomDTO request) {
        Department entity = DepartamentMapper.toCustomEntity(request);
        return DepartamentMapper.toCustomDTO(departamentRepository.save(entity));
    }
}
