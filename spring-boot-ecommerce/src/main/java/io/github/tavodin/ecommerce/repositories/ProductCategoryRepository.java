package io.github.tavodin.ecommerce.repositories;

import io.github.tavodin.ecommerce.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
