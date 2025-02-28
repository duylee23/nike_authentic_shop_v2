package com.nike.productservice.configuration;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary configKey() {
        Map<String, String> config = new HashMap();
        config.put("cloud_name", "du1cnvkkt");
        config.put("api_key", "388428358871528");
        config.put("api_secret", "gGQGhOvK1ELwUfNAupFyetcVdvo");
        Cloudinary cloudinary = new Cloudinary(config);
        return cloudinary;
    }
}
