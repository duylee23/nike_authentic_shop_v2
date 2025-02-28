package com.nike.productservice.service;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public String hello() {
        return "hello";
    }
}
