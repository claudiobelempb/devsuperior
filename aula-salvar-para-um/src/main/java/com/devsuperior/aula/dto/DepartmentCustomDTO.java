package com.devsuperior.aula.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record DepartmentCustomDTO(
        Long id,
        String name,
        List<PersonDTO> people
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 4861632665980168941L;
}
