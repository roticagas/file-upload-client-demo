package com.example.fileuploadclientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    UploadClientService service;

    @PostMapping(path = "/client")
    public void client() {
        service.upload();
    }

}
