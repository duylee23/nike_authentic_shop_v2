package com.nike.productservice.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;


@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public String uploadFile(MultipartFile file) throws IOException {
        assert file.getOriginalFilename() != null;
        String publicValue = generatePublicValues(file.getOriginalFilename());
        String extension = getFilename(file.getOriginalFilename())[1];
        File fileUpload = convertFile(file);

        cloudinary.uploader().upload(fileUpload, ObjectUtils.asMap("public_id", publicValue));
        cloudinary.url().generate(publicValue + "." + extension);
        cleanDisk(fileUpload);
        return null;
    }

    private File convertFile(MultipartFile file) {
        assert file.getOriginalFilename() != null;
        File convertFile = new File(generatePublicValues(file.getOriginalFilename()) + getFilename(file.getOriginalFilename())[1]);
        try{
            InputStream is = file.getInputStream();
            Files.copy(is, convertFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertFile;
    }

    private void cleanDisk(File file) {
        try{
            Path filePath = file.toPath();
            Files.delete(filePath);
        } catch (IOException e) {

        }
    }

    public String generatePublicValues(String originalName){
        String fileName = getFilename(originalName)[0];
        return UUID.randomUUID().toString() +  "_" + fileName;
    }

    public String[] getFilename(String originalName){
        return originalName.split("\\.");
    }
}
