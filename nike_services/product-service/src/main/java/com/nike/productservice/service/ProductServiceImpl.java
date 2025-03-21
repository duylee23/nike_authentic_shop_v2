package com.nike.productservice.service;

import com.nike.productservice.dto.ProductDTO;
import com.nike.productservice.entity.Product;
import com.nike.productservice.repository.ProductRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public String addProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        this.productRepository.save(product);
        return "";
    }

    @Override
    public List<Product> getPage(ProductDTO dto) throws IOException {
        return this.productRepository.findAll();
    }

}
