package com.devsuperior.aulalazy.dto;

import java.io.Serial;
import java.io.Serializable;

public record EmployeeMinDTO(
        Long id,
        String name,
        String email
) implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
}
