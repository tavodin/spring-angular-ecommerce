package io.github.tavodin.ecommerce.services;

import io.github.tavodin.ecommerce.dto.ProductDTO;
import io.github.tavodin.ecommerce.exceptions.ResourceNotFoundException;
import io.github.tavodin.ecommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public PagedModel<ProductDTO> findAllProducts(Pageable pageable) {
        Page<ProductDTO> productPaged = repository.findAll(pageable).map(ProductDTO::new);
        return new PagedModel<>(productPaged);
    }

    @Transactional(readOnly = true)
    public ProductDTO findByProductId(Long id) {
        return repository.findById(id)
                .map(ProductDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Transactional(readOnly = true)
    public PagedModel<ProductDTO> findProductsByCategoryId(Long id, Pageable pageable) {
        Page<ProductDTO> productPaged = repository.findByCategory_Id(id, pageable).map(ProductDTO::new);
        return new PagedModel<>(productPaged);
    }
}
