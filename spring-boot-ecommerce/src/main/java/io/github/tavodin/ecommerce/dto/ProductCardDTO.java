package io.github.tavodin.ecommerce.dto;

import java.math.BigDecimal;

public class ProductCardDTO {

    private Long id;
    private String name;
    private String imageUrl;
    private BigDecimal unitPrice;

    public ProductCardDTO(Long id, String name, String imageUrl, BigDecimal unitPrice) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
