package com.nike.authservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {
    String uploadFile(MultipartFile file) throws IOException;
}
