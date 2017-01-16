package uk.co.aws.bean;

import java.util.ArrayList;
import java.util.List;

public class Document {
	
	private String batchId;
	private String documentId;
	private String documentCode;
	private String deliveryType;
	private String filePath;
	private String creationDate;
	private String documentType;
	private String id = "";
	private String targetSystem = "UNREF";
	private String isReferenced;
	private String targetDocumentType;
	private String targetDocumentSubType;
	private String errorMessage;
	private String isPayment = "";
	private String lineOfBusiness;
	private List<String> fileList = new ArrayList<String>();
	private List<String> excelList = new ArrayList<String>();
	
	//TFS489
	private Double fileSize;
	
	public Double getFileSize() {
		return fileSize;
	}

	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}
	
	public Document()	
	{
		
	}
	
	public Document(SPSDocument document)	
	{
		this.batchId = document.getBatchId();
		this.documentCode = document.getDocumentCode();
		this.deliveryType = document.getDeliveryType();
		this.filePath = document.getFilePath();
		this.creationDate = document.getCreationDate();
		this.documentId = document.getDocumentId();
		
	}
	
	public String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(String documentCode) {
		this.documentCode = documentCode;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTargetSystem() {
		return targetSystem;
	}
	public void setTargetSystem(String targetSystem) {
		this.targetSystem = targetSystem;
	}
	public String getIsReferenced() {
		return isReferenced;
	}
	public void setIsReferenced(String isReferenced) {
		this.isReferenced = isReferenced;
	}
	public String getTargetDocumentSubType() {
		return targetDocumentSubType;
	}
	public void setTargetDocumentSubType(String targetDocumentSubType) {
		this.targetDocumentSubType = targetDocumentSubType;
	}
	public List<String> getFileList() {
		return fileList;
	}
	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getTargetDocumentType() {
		return targetDocumentType;
	}

	public void setTargetDocumentType(String targetDocumentType) {
		this.targetDocumentType = targetDocumentType;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
	public String getIsPayment() {
		return isPayment;
	}

	public void setIsPayment(String isPayment) {
		this.isPayment = isPayment;
	}

	public String getLineOfBusiness() {
		return lineOfBusiness;
	}

	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}

	public List<String> getExcelList() {
		return excelList;
	}

	public void setExcelList(List<String> excelList) {
		this.excelList = excelList;
	}
	

}
