package com.example.springboot.loginpage.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.springboot.loginpage.db.model.FileUploadDbModel;

public interface FileUploadRepository extends CrudRepository<FileUploadDbModel, Long> {

	FileUploadDbModel findByOrderIdAndFileType(String orderId, String fileType);
}
