package com.devsuperior.aulalazy.dto;

import java.io.Serial;
import java.io.Serializable;

public record EmployeeDepartmentDTO(
        Long id,
        String name,
        String email,
        DepartmentDTO department
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
