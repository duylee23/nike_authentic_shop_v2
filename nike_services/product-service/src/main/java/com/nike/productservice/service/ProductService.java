package com.nike.productservice.service;

import com.nike.productservice.dto.ProductDTO;


public interface ProductService {
//    PageResponse<ProductDTO> getPage(ProductDTO dto) throws IOException;

    String addProduct(ProductDTO dto);

    void createProduct (String productType, ProductDTO dto);
}
