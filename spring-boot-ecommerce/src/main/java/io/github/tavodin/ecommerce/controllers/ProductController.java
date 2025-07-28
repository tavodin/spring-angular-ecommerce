package io.github.tavodin.ecommerce.controllers;

import io.github.tavodin.ecommerce.dto.ProductCardDTO;
import io.github.tavodin.ecommerce.dto.ProductInfoDTO;
import io.github.tavodin.ecommerce.services.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public PagedModel<ProductInfoDTO> findAllProductsPaged(Pageable pageable) {
        return service.findAllProducts(pageable);
    }

    @GetMapping("/{id}")
    public ProductInfoDTO findByProductId(@PathVariable Long id) {
        return service.findByProductId(id);
    }

    @GetMapping("/search/findByCategoryId")
    public PagedModel<ProductCardDTO> findProductsByCategoryId(
            @RequestParam(name = "id", defaultValue = "1") Long id,
            Pageable pageable) {
        return service.findProductsByCategoryId(id, pageable);
    }

    @GetMapping("/search/findByNameContaining")
    public PagedModel<ProductCardDTO> findProductsByCategoryId(
            @RequestParam(name = "name", defaultValue = "Python") String name,
            Pageable pageable) {
        return service.findProductsByName(name, pageable);
    }
}
