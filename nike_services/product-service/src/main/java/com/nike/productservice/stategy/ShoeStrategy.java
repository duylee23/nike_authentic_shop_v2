package com.nike.productservice.stategy;

import com.nike.productservice.dto.ProductDTO;
import com.nike.productservice.entity.ShoeEntity;
import com.nike.productservice.repository.ShoeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShoeStrategy implements ProductStrategy {
    private final ShoeRepository shoeRepository;

    @Override
    public void createProduct(ProductDTO dto) {
        ShoeEntity shoe = ShoeEntity.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .image(dto.getImage())
                .description(dto.getDescription())
                .status(dto.getStatus())
                .build();
        this.shoeRepository.save(shoe);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        return null;
    }
}
