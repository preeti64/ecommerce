package com.menu.demoecommerce.category.service;

import com.menu.demoecommerce.category.model.Category;
import com.menu.demoecommerce.category.model.Product;
import com.menu.demoecommerce.category.repository.ProductRepository;
import com.menu.demoecommerce.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void addProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setProductDescription(productDto.getProductDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(category);
        productRepository.save(product);
    }

    public ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductDescription(product.getProductDescription());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setProductName(product.getProductName());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setPrice(product.getPrice());
        productDto.setId(product.getId());
        return productDto;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product: allProducts) {
            productDtos.add(getProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(ProductDto productDto, Long productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        // throw an exception if product does not exists
        if (!optionalProduct.isPresent()) {
            throw new Exception("product not present");
        }
        Product product = optionalProduct.get();
        product.setProductDescription(productDto.getProductDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }
}
