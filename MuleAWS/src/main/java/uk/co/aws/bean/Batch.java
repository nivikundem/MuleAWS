package uk.co.aws.bean;

import java.util.ArrayList;

public class Batch {
	private ArrayList<Document> documentList = new ArrayList<Document>();
	private String isreferenced;
	private int batchCounter;
	
	public String getIsreferenced() {
		return isreferenced;
	}
	public void setIsreferenced(String isreferenced) {
		this.isreferenced = isreferenced;
	}
	public ArrayList<Document> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(ArrayList<Document> documentList) {
		this.documentList = documentList;
	}
	public int getBatchCounter() {
		return batchCounter;
	}
	public void setBatchCounter(int batchCounter) {
		this.batchCounter = batchCounter;
	}
}
