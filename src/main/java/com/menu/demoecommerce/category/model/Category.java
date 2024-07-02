package com.menu.demoecommerce.category.model;



import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "category_name")
    private  String categoryName;;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column(name = "image_url")
    private  String imageUrl;
}

