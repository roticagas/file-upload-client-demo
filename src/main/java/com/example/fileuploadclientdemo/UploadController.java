package com.example.fileuploadclientdemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UploadController {
    @PostMapping(path = "/hello")
    public String hello() {
        System.out.println("hello");
        return "world";
    }

    @PostMapping(path = "/upload", consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public void upload(HttpServletRequest request, MultipartFile file) {
        try {
            System.out.println("upload + file.getContentType:" + file.getContentType());
            System.out.println("upload + file.getName:" + file.getName());
            System.out.println("upload + request:" + request.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
