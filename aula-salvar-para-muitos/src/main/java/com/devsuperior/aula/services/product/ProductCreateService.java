package com.devsuperior.aula.services.product;

import com.devsuperior.aula.dto.ProductDTO;
import com.devsuperior.aula.entities.Product;
import com.devsuperior.aula.mapper.ProductMapper;
import com.devsuperior.aula.repositories.CategoryRepository;
import com.devsuperior.aula.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreateService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductCreateService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO execute(ProductDTO dto){
        Product entity = ProductMapper.toEntity(dto, categoryRepository);
        entity = productRepository.save(entity);
        return ProductMapper.toDTO(entity);
    }
}
