/**
 * 
 */
package com.example.springboot.loginpage.controller;

import java.io.File;
import java.io.InputStream;

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
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.loginpage.service.FileUploadService;

import io.swagger.annotations.ApiParam;

/**
 * @author samasu5
 *
 */
@Controller
public class FileHandlerController {
	
	@Autowired
	private FileUploadService fileUploadService;

	@GetMapping(path = "/")
	public String uploadPage(ModelMap model) {
		model.put("isDownloadDisabled", Boolean.TRUE);
		return "fileupload";
	}
	
	@PostMapping(path = "/rest/demo/upload")
	public ResponseEntity<Resource> uploadFile() {
		System.out.println("************POST method Called *********");
		byte[] fileData = fileUploadService.uploadFileToDb("./src/main/resources/FirstPdf.pdf");
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/pdf"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"newPDFFile2.pdf\"")
                .body(new ByteArrayResource(fileData));
//		return "fileupload";
	}
	
	@PostMapping(path = "/")
	public String uploadFileToDb(ModelMap model, 
    		@ApiParam(name = "file") @RequestParam MultipartFile file,
    		@ApiParam(name = "fileType") @RequestParam String fileType,
    		@ApiParam(name = "orderId") @RequestParam String orderId) {
		System.out.println("************POST method Called *********");
		fileUploadService.uploadLocalFileToDb(file, orderId, fileType);
		model.put("uploadStatus", "File upload successful for order id - "
				+orderId+" with file type - " +fileType);
		model.put("isDownloadDisabled", Boolean.FALSE);
		return "fileupload";
	}
	
}
