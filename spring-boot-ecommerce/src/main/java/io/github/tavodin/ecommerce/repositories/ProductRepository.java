package io.github.tavodin.ecommerce.repositories;

import io.github.tavodin.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByCategory_Id(@Param("id") Long id, Pageable pageable);
}
