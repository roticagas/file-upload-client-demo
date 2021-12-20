package com.example.fileuploadclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class FileUploadClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadClientDemoApplication.class, args);
    }

}
