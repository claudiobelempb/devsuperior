package com.devsuperior.aula.service;

import com.devsuperior.aula.dto.PersonDepartmentCustomDTO;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.mapper.PersonMapper;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonCreateService {
    private final PersonRepository personRepository;
    private final DepartmentRepository departmentRepository;

    public PersonCreateService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
        this.personRepository = personRepository;
        this.departmentRepository = departmentRepository;
    }

//    public PersonCustomDTO execute(PersonCustomDTO dto) {
//        Person entity = new Person();
//        entity.setName(dto.name());
//        entity.setSalary(dto.salary());
//
//        Department dept = departmentRepository.getReferenceById(dto.department().id());
//        /* Department dept = new Department();
//        dept.setId(dto.department().id()); */
//        entity.setDepartment(dept);
//        entity = personRepository.save(entity);
//
//        return new PersonCustomDTO(
//                entity.getId(),
//                entity.getName(),
//                entity.getSalary(),
//                new DepartmentDTO(
//                        entity.getDepartment().getId(),
//                        entity.getDepartment().getName()
//                ));
//    }

    public PersonDepartmentCustomDTO execute(PersonDepartmentCustomDTO dto) {
        Person entity = PersonMapper.toEntity(dto, departmentRepository);
        /*Department department = departmentRepository.getReferenceById(dto.departmentId());
        entity.setDepartment(department);*/
        entity = personRepository.save(entity);
        return PersonMapper.toDTO(entity);
    }

    /*public PersonCustomDTO execute(PersonCustomDTO dto) {
        Person entity = PersonMapper.toEntity(dto);
        Department department = departmentRepository.getReferenceById(dto.department().id());
        entity.setDepartment(department);
        entity = personRepository.save(entity);
        return PersonMapper.toDTO(entity);
    }*/

    /*public PersonCustomDTO execute(PersonCustomDTO dto) {
        Person entity = PersonMapper.toEntity(dto, departmentRepository);
        entity = personRepository.save(entity);
        return PersonMapper.toDTO(entity);
    }*/
}
