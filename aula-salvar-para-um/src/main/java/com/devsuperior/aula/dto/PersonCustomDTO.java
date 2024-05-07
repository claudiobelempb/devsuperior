package com.devsuperior.aula.dto;

import java.io.Serial;
import java.io.Serializable;

public record PersonCustomDTO(
        Long id,
        String name,
        Double salary,
        DepartmentDTO department
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -286391865846298555L;
}
