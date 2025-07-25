package io.github.tavodin.ecommerce.dto;

import io.github.tavodin.ecommerce.entities.ProductCategory;

public class ProductCategoryDTO {

    private Long id;
    private String categoryName;

    public ProductCategoryDTO() {
    }

    public ProductCategoryDTO(ProductCategory entity) {
        this.id = entity.getId();
        this.categoryName = entity.getCategoryName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
