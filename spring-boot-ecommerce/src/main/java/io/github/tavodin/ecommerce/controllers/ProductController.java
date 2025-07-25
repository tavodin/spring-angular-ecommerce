package io.github.tavodin.ecommerce.controllers;

import io.github.tavodin.ecommerce.dto.ProductDTO;
import io.github.tavodin.ecommerce.services.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public PagedModel<ProductDTO> findAllProductsPaged(Pageable pageable) {
        return service.findAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public ProductDTO findByProductId(@PathVariable Long id) {
        return service.findByProductId(id);
    }
}
