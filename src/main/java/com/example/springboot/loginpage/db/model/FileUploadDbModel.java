/**
 * 
 */
package com.example.springboot.loginpage.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/**
 * @author samasu5
 *
 */
@Entity
@Table (name = "VSIB_FILE_STORAGE")
@Component
public class FileUploadDbModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 754439989654621429L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fileupload_seq")
	@SequenceGenerator(name = "fileupload_seq", sequenceName = "VSIB_FILE_UPLOAD_SEQ", allocationSize=1)
	@Column (name = "FILE_UPLOAD_ID")
	private Long fileUploadId;
	
	@Column (name = "FILE_TYPE")
	private String fileType;
	
	@Lob
	@Column (name = "FILE_DATA")
	private byte[] data;
	
	@Column (name = "APP_NAME")
	private String appName;

	@Column (name = "ORDER_ID")
	private String orderId;
	
	@Column (name = "PON")
	private String pon;
	
	@Column (name = "DATE_CREATED")
	private Date dateCreated;
	
	@Column (name = "DATE_LAST_UPDATED")
	private Date dateLastUpdated;

	/**
	 * @return the fileUploadId
	 */
	public Long getFileUploadId() {
		return fileUploadId;
	}

	/**
	 * @param fileUploadId the fileUploadId to set
	 */
	public void setFileUploadId(Long fileUploadId) {
		this.fileUploadId = fileUploadId;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return fileType;
	}

	/**
	 * @param fileType the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the data
	 */
	public byte[] getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(byte[] data) {
		this.data = data;
	}

	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}

	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the pon
	 */
	public String getPon() {
		return pon;
	}

	/**
	 * @param pon the pon to set
	 */
	public void setPon(String pon) {
		this.pon = pon;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateLastUpdated
	 */
	public Date getDateLastUpdated() {
		return dateLastUpdated;
	}

	/**
	 * @param dateLastUpdated the dateLastUpdated to set
	 */
	public void setDateLastUpdated(Date dateLastUpdated) {
		this.dateLastUpdated = dateLastUpdated;
	}
	
}
