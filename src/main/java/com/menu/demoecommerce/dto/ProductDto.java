package com.menu.demoecommerce.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String productName;
    private String productDescription;
    private double price;
    private String imageUrl;
    private Long categoryId;
}
