package com.devsuperior.aulalazy.services;

import com.devsuperior.aulalazy.dto.DepartmentDTO;
import com.devsuperior.aulalazy.dto.EmployeeDepartmentDTO;
import com.devsuperior.aulalazy.dto.EmployeeMinDTO;
import com.devsuperior.aulalazy.entities.Employee;
import com.devsuperior.aulalazy.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    public EmployeeMinDTO findByIdMin(Long id) {
        Optional<Employee> result = repository.findById(id);
        return new EmployeeMinDTO(result.get().id, result.get().name, result.get().email);
    }

    @Transactional(readOnly = true)
    public EmployeeDepartmentDTO findByIdWithDepartment(Long id) {
        Optional<Employee> result = repository.findById(id);
        return new EmployeeDepartmentDTO(
                result.get().getId(),
                result.get().getName(),
                result.get().getEmail(),
                new DepartmentDTO(result.get().getDepartment().getId(), result.get().getDepartment().getName())
        );
    }

    @Transactional(readOnly = true)
    public List<EmployeeDepartmentDTO> findEmployeesWithDepartments() {
        List<Employee> result = repository.findEmployeesWithDepartments();
        return result.stream().map(x -> new EmployeeDepartmentDTO(
                x.getId(),
                x.getName(),
                x.getEmail(),
                new DepartmentDTO(x.getId(), x.getName())
        )).collect(Collectors.toList());
    }
}
