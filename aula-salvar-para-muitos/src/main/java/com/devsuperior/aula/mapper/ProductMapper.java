package com.devsuperior.aula.mapper;

import com.devsuperior.aula.dto.CategoryDTO;
import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Category;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.repositories.CategoryRepository;

import java.util.stream.Collectors;

public final class ProductMapper {
    public static ProductDTO toDTO(Product entity) {
        return new ProductDTO(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getCategories().stream().map(category -> new CategoryDTO(category.getId(), category.getName())).collect(Collectors.toList())
        );
    }

    public static Product toEntity(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.name());
        entity.setPrice(dto.price());
        dto.categories().stream().map(c -> entity.getCategories().add(new Category(c.id(), c.name()))).collect(Collectors.toList());
        return entity;
    }

    public static Product toEntity(ProductDTO dto, CategoryRepository categoryRepository) {
        Product entity = new Product();
        entity.setName(dto.name());
        entity.setPrice(dto.price());
        dto.categories().stream().map(c -> entity.getCategories().add(categoryRepository.getReferenceById(c.id()))).collect(Collectors.toList());
        return entity;
    }
}
