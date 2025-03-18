package com.nike.productservice.dto;

import lombok.Data;


@Data
public class ProductDTO {
    private String name;
    private String description;
    private Double price;
}
