package uk.co.aws.bean;

import java.util.ArrayList;

public class SPSDocument {
	private String batchId;
	private String documentId;
	private String documentCode;
	private String deliveryType;
	private String filePath;
	private String creationDate;
	private ArrayList<SPSMetaData> metaData = new ArrayList<SPSMetaData>();
	
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
	public ArrayList<SPSMetaData> getMetaData() {
		return metaData;
	}
	public void setMetaData(ArrayList<SPSMetaData> metaData) {
		this.metaData = metaData;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
	
	
}
