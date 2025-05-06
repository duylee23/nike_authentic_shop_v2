package com.nike.productservice.service;

import com.nike.productservice.dto.ProductDTO;
import com.nike.productservice.entity.ProductEntity;
import com.nike.productservice.repository.ProductRepository;
import com.nike.productservice.stategy.ProductStrategy;
import com.nike.productservice.stategy.ProductStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductStrategyFactory strategyFactory;

    @Override
    public String addProduct(ProductDTO dto) {
        ProductEntity product = new ProductEntity();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        this.productRepository.save(product);
        return "";
    }

//    @Override
//    public PageResponse<ProductDTO> getPage(ProductDTO dto) throws IOException {
//        return this.productRepository.findAll();
//    }

    @Override
    public void createProduct(String productType, ProductDTO dto) {
        ProductStrategy strategy = strategyFactory.getStrategy(productType);
        strategy.createProduct(dto);
    }
}
