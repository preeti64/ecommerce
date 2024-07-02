package com.menu.demoecommerce.category.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productDescription;
    private String imageUrl;
    private double price;;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
