package uk.co.aws.bean;

import java.io.Serializable;
import java.util.ArrayList;


public class RTMClaim implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1337314458351061387L;
	
	private String fileName;
	private String description;
	private ArrayList<String> fileList = new ArrayList<String>();
	
	
	private String header1 = "";
	private String header2 = "";
	private String header3 = "";
	private String header4 = "";
	private String header5 = "";
	private String header6 = "";
	
	
	
	public RTMClaim(String header1, String header2,  String header3,  String header4,  String header5,  String header6, String fileName) {
		if(header1.equals("1"))
		{
			this.header1 = "INV";
		}
		else if(header1.equals("2"))
		{
			this.header1 = "DTL";
		}
		else if(header1.equals("3"))
		{
			this.header1 = "TRL";
		}
		
		this.header2 = header2;
		this.header3 = header3;
		this.header4 = header4;
		this.header5 = header5;
		this.header6 = header6;
		this.fileName = fileName;
	}
	public RTMClaim(String header1, String header2,  String header3) {
		if(header1.equals("1"))
		{
			this.header1 = "INV";
		}
		else if(header1.equals("2"))
		{
			this.header1 = "DTL";
		}
		else if(header1.equals("3"))
		{
			this.header1 = "TRL";
		}
		
		this.header2 = header2;
		this.header3 = header3;
		
		
	}

	public String getHeader1() {
		return header1;
	}

	public void setHeader1(String header1) {
		this.header1 = header1;
	}

	public String getHeader2() {
		return header2;
	}

	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	public String getHeader3() {
		return header3;
	}

	public void setHeader3(String header3) {
		this.header3 = header3;
	}

	public String getHeader4() {
		return header4;
	}

	public void setHeader4(String header4) {
		this.header4 = header4;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHeader5() {
		return header5;
	}

	public void setHeader5(String header5) {
		this.header5 = header5;
	}

	public String getHeader6() {
		return header6;
	}

	public void setHeader6(String header6) {
		this.header6 = header6;
	}

	public RTMClaim(String fileName, String description, ArrayList<String> fileList) {
		this.fileName = fileName;
		this.description = description;
		this.fileList = fileList;
	}
	public ArrayList<String> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<String> fileList) {
		this.fileList = fileList;
	}

}