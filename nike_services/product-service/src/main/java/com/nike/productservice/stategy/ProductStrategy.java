package com.nike.productservice.stategy;


import com.nike.productservice.dto.ProductDTO;

public interface ProductStrategy {
    void createProduct(ProductDTO dto);
    ProductDTO getProduct(Long id);
}
