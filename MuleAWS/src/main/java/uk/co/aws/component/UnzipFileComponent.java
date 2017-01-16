package uk.co.aws.component;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import uk.co.aws.util.EquityUtility;


public class UnzipFileComponent implements Callable {

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		
		
		String filename = eventContext.getMessage().getProperty("BatchZipName", PropertyScope.INVOCATION);
		String inputFolder = eventContext.getMessage().getProperty("inputFolder", PropertyScope.INVOCATION);		
		String outputImageFolder = eventContext.getMessage().getProperty("outputImageFolder", PropertyScope.INVOCATION);
		
		int noOfDocsFromZip=0;
		List<String> fileList = new ArrayList<String>();
		
		ZipFile zipFile = new ZipFile(inputFolder+"/" + filename);		
		Enumeration entries = zipFile.entries();
		String xmlName = "";
		while(entries.hasMoreElements())
        {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			String fn = entry.getName();
		
			if((fn.endsWith("PDF"))){
				fileList.add(fn);
				noOfDocsFromZip++;
				
			}
			if((fn.endsWith("xls")) || (fn.endsWith("xlsx"))){
				noOfDocsFromZip++;	
				//System.out.println("noOfExcelFromZip  "+noOfExcelFromZip);
			}
			
			if(fn.endsWith("XML"))
				xmlName = fn;			
		}
		zipFile.close();
		
		eventContext.getMessage().setProperty("xmlName",xmlName, PropertyScope.INVOCATION);				
		eventContext.getMessage().setProperty("noOfDocsFromZip", noOfDocsFromZip, PropertyScope.INVOCATION);
		EquityUtility.unzipFile(inputFolder, outputImageFolder, filename);	
		System.out.println("xmlName  "+xmlName);
		return xmlName;
	}	

}

