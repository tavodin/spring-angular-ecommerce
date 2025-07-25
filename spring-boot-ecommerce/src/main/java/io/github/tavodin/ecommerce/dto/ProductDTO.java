package io.github.tavodin.ecommerce.dto;

import io.github.tavodin.ecommerce.entities.Product;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductDTO {

    private Long id;
    private String sku;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

    public ProductDTO() {
    }

    public ProductDTO(Product p) {
        this.id = p.getId();
        this.sku = p.getSku();
        this.description = p.getDescription();
        this.unitPrice = p.getUnitPrice();
        this.imageUrl = p.getImageUrl();
        this.active = p.isActive();
        this.unitsInStock = p.getUnitsInStock();
        this.dateCreated = p.getDateCreated();
        this.lastUpdated = p.getLastUpdated();
    }

    public Long getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isActive() {
        return active;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
}
