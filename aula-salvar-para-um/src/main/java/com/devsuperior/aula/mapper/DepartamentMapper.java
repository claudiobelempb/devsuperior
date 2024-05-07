package com.devsuperior.aula.mapper;

import com.devsuperior.aula.dto.DepartmentCustomDTO;
import com.devsuperior.aula.dto.DepartmentDTO;
import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.entities.Department;

import java.util.stream.Collectors;

public final class DepartamentMapper {
    public static DepartmentDTO toDTO(Department entity) {
        return new DepartmentDTO(
                entity.getId(),
                entity.getName()
        );
    }

    public static DepartmentCustomDTO toCustomDTO(Department entity) {
        return new DepartmentCustomDTO(
                entity.getId(),
                entity.getName(),
                entity.getPeople().stream().map(p -> new PersonDTO(p.getId(), p.getName(), p.getSalary())).collect(Collectors.toList())
        );
    }

    public static Department toEntity(DepartmentDTO dto) {
        return new Department(
                dto.id(),
                dto.name()
        );
    }

    public static Department toCustomEntity(DepartmentCustomDTO dto) {
        return new Department(
                dto.id(),
                dto.name()
        );
    }
}
