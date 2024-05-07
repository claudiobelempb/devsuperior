package com.devsuperior.aula.mapper;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.entities.Category;

public final class CategoryMapper {
    public static CategoryDTO toDTO(Category entity) {
        return new CategoryDTO(
                entity.getId(),
                entity.getName()
        );
    }

    public static Category toEntity(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.name());
        return entity;
    }
}
