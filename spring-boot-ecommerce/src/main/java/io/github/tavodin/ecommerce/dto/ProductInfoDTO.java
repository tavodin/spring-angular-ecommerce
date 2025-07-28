package io.github.tavodin.ecommerce.dto;

import io.github.tavodin.ecommerce.entities.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductInfoDTO {

    private Long id;
    private String name;
    private String sku;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;

    public ProductInfoDTO() {
    }

    public ProductInfoDTO(Long id, String name, String sku, String description, BigDecimal unitPrice, String imageUrl, boolean active, int unitsInStock, LocalDateTime dateCreated, LocalDateTime lastUpdated) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
    }

    public ProductInfoDTO(Product p) {
        this.id = p.getId();
        this.name = p.getName();
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

    public String getName() {
        return name;
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
