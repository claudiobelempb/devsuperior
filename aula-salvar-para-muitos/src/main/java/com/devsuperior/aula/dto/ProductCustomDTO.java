package com.devsuperior.aula.dto;

import java.util.List;

public record ProductCustomDTO(
        Long id,
        String name,
        Double price,
        List<CategoryDTO> categories
) {
}
