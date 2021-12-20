package com.example.fileuploadclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class UploadClientService {


    @PostConstruct
    public void start() {
        System.out.println("UploadClientService start");
    }

    public void upload() {
        try {
            File file = File.createTempFile("data", ".csv");
            FileOutputStream stream = new FileOutputStream(file);
            stream.write("msisdn,custnum\n".getBytes(StandardCharsets.UTF_8));
            stream.write("668812345678,11111\n".getBytes(StandardCharsets.UTF_8));
            stream.write("668812345679,22222\n".getBytes(StandardCharsets.UTF_8));
            stream.close();
            LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            map.add("file", new FileSystemResource(file));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForLocation("http://localhost:8080/upload", requestEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
