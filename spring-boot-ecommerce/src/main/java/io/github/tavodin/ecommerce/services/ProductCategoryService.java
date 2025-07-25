package io.github.tavodin.ecommerce.services;

import io.github.tavodin.ecommerce.dto.ProductCategoryDTO;
import io.github.tavodin.ecommerce.exceptions.ResourceNotFoundException;
import io.github.tavodin.ecommerce.repositories.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private ProductCategoryRepository repository;

    public ProductCategoryService(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    public List<ProductCategoryDTO> findAllCategories() {
        return repository.findAll().stream()
                .map(ProductCategoryDTO::new)
                .toList();
    }

    public ProductCategoryDTO findByCategoryId(Long id) {
        return repository.findById(id)
                .map(ProductCategoryDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found!"));
    }
}
