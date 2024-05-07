package com.devsuperior.aula.mapper;

import com.devsuperior.aula.dto.PersonCustomDTO;
import com.devsuperior.aula.dto.PersonDepartmentCustomDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;

public final class PersonMapper {

    public static PersonDepartmentCustomDTO toDTO(Person entity) {
        return new PersonDepartmentCustomDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                entity.getDepartment().getId()
        );
    }

    public static Person toEntity(PersonDepartmentCustomDTO dto, DepartmentRepository departmentRepository) {
        Person entity = new Person();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setSalary(dto.salary());
        entity.setDepartment(departmentRepository.getReferenceById(dto.departmentId()));
        return entity;
    }

    /*public static PersonCustomDTO toDTO(Person entity) {
        return new PersonCustomDTO(
                entity.getId(),
                entity.getName(),
                entity.getSalary(),
                new DepartmentDTO(entity.getDepartment().getId(), entity.getDepartment().getName())
        );
    }*/

    public static Person toEntity(PersonCustomDTO dto) {
        Person entity = new Person();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setSalary(dto.salary());
        entity.setDepartment(new Department(dto.department().id(), dto.department().name()));
        return entity;
    }

    public static Person toEntity(PersonCustomDTO dto, DepartmentRepository departmentRepository) {
        Person entity = new Person();
        entity.setId(dto.id());
        entity.setName(dto.name());
        entity.setSalary(dto.salary());
        entity.setDepartment(departmentRepository.getReferenceById(dto.department().id()));
        return entity;
    }
}
