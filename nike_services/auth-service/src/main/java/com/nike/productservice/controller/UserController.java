package com.nike.productservice.controller;


import com.nike.productservice.entity.User;
import com.nike.productservice.service.AuthService;
import com.nike.productservice.service.UploadFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final AuthService productService;
    private final UploadFileService uploadFileService;

//    @RequestMapping(method = RequestMethod.POST, value = "/page")
//    public List<User> hello(@RequestBody ProductDTO dto) throws IOException {
//        return this.productService.getPage(dto);
//    }

    @PostMapping(value = "/image")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadFileService.uploadFile(file);
    }

//    @PostMapping(value = "/add")
//    public String uploadFile(@RequestBody ProductDTO dto) throws IOException {
//        return productService.addProduct(dto);
//    }
}
