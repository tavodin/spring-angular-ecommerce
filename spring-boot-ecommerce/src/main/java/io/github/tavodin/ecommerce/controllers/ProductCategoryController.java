package io.github.tavodin.ecommerce.controllers;

import io.github.tavodin.ecommerce.dto.ProductCategoryDTO;
import io.github.tavodin.ecommerce.services.ProductCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/product-categories")
public class ProductCategoryController {

    private ProductCategoryService service;

    public ProductCategoryController(ProductCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductCategoryDTO> findAllCategories() {
        return service.findAllCategories();
    }

    @GetMapping("/{id}")
    public ProductCategoryDTO findByCategoryId(@PathVariable Long id) {
        return service.findByCategoryId(id);
    }
}
