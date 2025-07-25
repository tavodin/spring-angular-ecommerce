package io.github.tavodin.ecommerce.services;

import io.github.tavodin.ecommerce.dto.ProductDTO;
import io.github.tavodin.ecommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public PagedModel<ProductDTO> findAllProducts(Pageable pageable) {
        Page<ProductDTO> productPaged = repository.findAll(pageable).map(ProductDTO::new);
        return new PagedModel<>(productPaged);
    }
}
