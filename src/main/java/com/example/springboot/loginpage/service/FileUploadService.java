/**
 * 
 */
package com.example.springboot.loginpage.service;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.loginpage.db.model.FileUploadDbModel;
import com.example.springboot.loginpage.repository.FileUploadRepository;
import com.example.springboot.loginpage.utils.CreatePdfFile;

/**
 * @author samasu5
 *
 */
@Component
public class FileUploadService {

	@Autowired
	private CreatePdfFile createPdfFile;
	
	@Autowired
	private FileUploadRepository fileUploadRepository;
	
	@Autowired
	com.example.springboot.loginpage.utils.WriteToFile writeToFile;
	
	public byte[] uploadFileToDb(String fileLocation) {
		
		FileUploadDbModel fileUploadDbModelNew = null;
		try {
			createPdfFile.createFile(fileLocation);
			File pdfFile = new File(fileLocation);
			byte[] pdfData = new byte[(int) pdfFile.length()];
			DataInputStream dis = new DataInputStream(new FileInputStream(pdfFile));
			dis.readFully(pdfData);  // read from file into byte[] array
			dis.close();
			FileUploadDbModel fileUploadDbModel = new FileUploadDbModel();
			fileUploadDbModel.setAppName("CPQ");
			fileUploadDbModel.setData(pdfData);
			fileUploadDbModel.setDateCreated(new Date());
			fileUploadDbModel.setDateLastUpdated(new Date());
			fileUploadDbModel.setFileType("LOA");
			fileUploadDbModel.setOrderId("1234");
			fileUploadDbModel.setPon("12345");
			
			fileUploadRepository.save(fileUploadDbModel);
			
			fileUploadDbModelNew = fileUploadRepository.findByOrderIdAndFileType("1234","LOA");
			
//			writeToFile.writeFile(fileUploadDbModelNew.getData(), "newPDFFile2.pdf");
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
		return fileUploadDbModelNew.getData();
	}
	
	public byte[] downloadFileFromDb(String orderId, String fileType) {
		FileUploadDbModel fileUploadDbModelNew = null;
		
		try {
			fileUploadDbModelNew = fileUploadRepository.findByOrderIdAndFileType(orderId, fileType);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return fileUploadDbModelNew.getData();
	}

	public void uploadLocalFileToDb(MultipartFile fileToUpload, String orderId, String fileType) {
		
		try {
			byte[] pdfData = fileToUpload.getBytes();
			/*DataInputStream dis = new DataInputStream(new FileInputStream("./src/main/resources/"+fileToUpload.getOriginalFilename()));
			dis.readFully(pdfData);  // read from file into byte[] array
			dis.close();*/
			FileUploadDbModel fileUploadDbModel = new FileUploadDbModel();
			fileUploadDbModel.setAppName("CPQ");
			fileUploadDbModel.setData(pdfData);
			fileUploadDbModel.setDateCreated(new Date());
			fileUploadDbModel.setDateLastUpdated(new Date());
			fileUploadDbModel.setFileType(fileType);
			fileUploadDbModel.setOrderId(orderId);
			fileUploadDbModel.setPon("12345");
			
			fileUploadRepository.save(fileUploadDbModel);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}
}
