package io.github.tavodin.ecommerce.repositories;

import io.github.tavodin.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
