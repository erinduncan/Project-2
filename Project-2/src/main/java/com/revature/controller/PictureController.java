package com.revature.controller;

import com.revature.service.PictureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;



@Controller
@CrossOrigin(origins = {"http://localhost:8080"})
public class PictureController {

    private PictureService ps;
    
    @Autowired
    public PictureController(PictureService ps) {
        this.ps = ps;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/upload.app", produces = "application/json")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return ps.upload(file);
    }
    
}