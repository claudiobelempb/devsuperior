package com.devsuperior.aula.dto;

import java.io.Serial;
import java.io.Serializable;

public record PersonDepartmentCustomDTO(
        Long id,
        String name,
        Double salary,
        Long departmentId
) implements Serializable {

    @Serial
    private static final long serialVersionUID = -286391865846298555L;
}
