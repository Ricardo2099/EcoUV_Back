package com.ecouv.EcoUv.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinaryService {

    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Value("${cloudinary.api_key}")
    private String apiKey;

    @Value("${cloudinary.api_secret}")
    private String apiSecret;

    @Value("${cloudinary.folder}")
    private String folder;

    private Cloudinary cloudinary;

    private Cloudinary getCloudinary() {
        if (cloudinary == null) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret,
                    "secure", true
            ));
        }
        return cloudinary;
    }

    public String uploadImage(MultipartFile file) {
        try {
            Map uploadResult = getCloudinary().uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("folder", folder)
            );

            return uploadResult.get("secure_url").toString();

        } catch (Exception e) {
            throw new RuntimeException("Error al subir la imagen a Cloudinary", e);
        }
    }
}
