package io.github.tavodin.ecommerce.repositories;

import io.github.tavodin.ecommerce.dto.ProductCardDTO;
import io.github.tavodin.ecommerce.dto.ProductInfoDTO;
import io.github.tavodin.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
            SELECT new io.github.tavodin.ecommerce.dto.ProductCardDTO(p.id, p.name, p.imageUrl, p.unitPrice)
            From Product p
            WHERE p.category.id = :id
            """,
            countQuery = """
            SELECT COUNT(p)
            FROM Product p
            WHERE p.category.id = :id
            """)
    Page<ProductCardDTO> findProductCardByCategoryId(@Param("id") Long id, Pageable pageable);

    @Query(value = """
            SELECT new io.github.tavodin.ecommerce.dto.ProductCardDTO(p.id, p.name, p.imageUrl, p.unitPrice)
            From Product p
            WHERE p.name LIKE CONCAT('%', :name, '%')
            """,
            countQuery = """
            SELECT COUNT(p)
            FROM Product p
            WHERE p.name LIKE CONCAT('%', :name, '%')
            """)
    Page<ProductCardDTO> findProductCardByName(@Param("name") String name, Pageable pageable);

    @Query("""
            SELECT new io.github.tavodin.ecommerce.dto.ProductInfoDTO(
                p.id, p.name, p.sku, p.description, p.unitPrice, p.imageUrl,
                p.active, p.unitsInStock, p.dateCreated, p.lastUpdated)
            FROM Product p
            WHERE p.id = :id
            """)
    Optional<ProductInfoDTO> findByIdWithNoCategory(@Param("id") Long id);
}
