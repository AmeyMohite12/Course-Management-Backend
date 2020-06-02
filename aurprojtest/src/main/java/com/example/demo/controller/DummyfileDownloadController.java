package com.example.demo.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dummyfile;
import com.example.demo.service.DummyfileService;

@RestController
@CrossOrigin
public class DummyfileDownloadController {

	@Autowired
	DummyfileService dummyfileservice;
	
	
	@GetMapping("/file/downloadFile/{fileName}")
	public ResponseEntity<Resource> downloadFile(@PathVariable Long fileName, HttpServletRequest request) {
        // Load file as Resource
        Dummyfile databaseFile = dummyfileservice.getFile(fileName);
        
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
    }
	
}
