package io.github.tavodin.ecommerce.services;

import io.github.tavodin.ecommerce.dto.ProductCardDTO;
import io.github.tavodin.ecommerce.dto.ProductInfoDTO;
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
    public PagedModel<ProductInfoDTO> findAllProducts(Pageable pageable) {
        Page<ProductInfoDTO> productPaged = repository.findAll(pageable).map(ProductInfoDTO::new);
        return new PagedModel<>(productPaged);
    }

    @Transactional(readOnly = true)
    public ProductInfoDTO findByProductId(Long id) {
        return repository.findByIdWithNoCategory(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    @Transactional(readOnly = true)
    public PagedModel<ProductCardDTO> findProductsByCategoryId(Long id, Pageable pageable) {
        Page<ProductCardDTO> productPaged = repository.findProductCardByCategoryId(id, pageable);
        return new PagedModel<>(productPaged);
    }

    @Transactional(readOnly = true)
    public PagedModel<ProductCardDTO> findProductsByName(String name, Pageable pageable) {
        Page<ProductCardDTO> productPaged = repository.findProductCardByName(name, pageable);
        return new PagedModel<>(productPaged);
    }
}
