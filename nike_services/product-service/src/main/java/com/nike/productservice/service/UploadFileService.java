package com.nike.productservice.service;

import com.nike.productservice.dto.ProductDTO;
import com.nike.productservice.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {
    String uploadFile(MultipartFile file) throws IOException;
}
