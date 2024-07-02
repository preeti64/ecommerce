package com.menu.demoecommerce.category.controller;

import com.menu.demoecommerce.category.model.ApiResponse;
import com.menu.demoecommerce.category.model.Category;
import com.menu.demoecommerce.category.model.Product;
import com.menu.demoecommerce.category.repository.CategoryRepository;
import com.menu.demoecommerce.category.service.ProductService;
import com.menu.demoecommerce.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){
        Optional<Category> optional  = categoryRepository.findById(productDto.getCategoryId());
        if(!optional.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "category does not exists"), HttpStatus.NOT_FOUND);
        }
        productService.addProduct(productDto, optional.get()) ;
        return new ResponseEntity<>(new ApiResponse(true, "a new product created"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> productDtoList = productService.getAllProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
    @PatchMapping("/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto, productId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been updated"), HttpStatus.OK);
    }

}
