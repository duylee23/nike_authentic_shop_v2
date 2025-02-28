package com.nike.productservice.controller;


import com.nike.productservice.service.ProductService;
import com.nike.productservice.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final UploadFileService uploadFileService;

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String hello(){
        return this.productService.hello();
    }

    @PostMapping(value = "/image")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadFileService.uploadFile(file);
    }
}
