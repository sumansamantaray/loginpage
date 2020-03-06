package com.example.springboot.loginpage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.springboot.loginpage.service.FileUploadService;

import io.swagger.annotations.ApiParam;

@Controller
@SessionAttributes("orderId")
public class FileDownloadController {
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@GetMapping(path = "/download")
	public String uploadPage(ModelMap model) {
		model.put("isDownloadDisabled", Boolean.TRUE);
		return "fileDownload";
	}

	@PostMapping(path = "/rest/demo/download")
	public ResponseEntity<Resource> downloadFile(ModelMap model, 
    		@ApiParam(name = "orderId") @RequestParam String orderId, 
    		@ApiParam(name = "fileName") @RequestParam String fileName) {
		System.out.println("************POST downloadFile method Called *********");
		byte[] fileData = fileUploadService.downloadFileFromDb(orderId, fileName);
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"downloadedFile\"")
                .body(new ByteArrayResource(fileData));
	}
}
