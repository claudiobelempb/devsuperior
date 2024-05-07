package com.devsuperior.aulalazy.dto;

import java.io.Serial;
import java.io.Serializable;

public record DepartmentDTO(
        Long id,
        String name
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

}
