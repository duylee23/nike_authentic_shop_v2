package com.nike.productservice.controller;


import com.nike.productservice.dto.ProductDTO;
import com.nike.productservice.entity.Product;
import com.nike.productservice.service.ProductService;
import com.nike.productservice.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping(method = RequestMethod.POST, value = "/page")
    public List<Product> hello(@RequestBody ProductDTO dto) throws IOException {
        return this.productService.getPage(dto);
    }

    @PostMapping(value = "/image")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadFileService.uploadFile(file);
    }

    @PostMapping(value = "/add")
    public String uploadFile(@RequestBody ProductDTO dto) throws IOException {
        return productService.addProduct(dto);
    }
}
