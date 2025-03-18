package com.nike.productservice.service;

import com.nike.productservice.dto.ProductDTO;
import com.nike.productservice.entity.Product;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    List<Product> getPage(ProductDTO dto) throws IOException;
    String addProduct(ProductDTO dto);

}
