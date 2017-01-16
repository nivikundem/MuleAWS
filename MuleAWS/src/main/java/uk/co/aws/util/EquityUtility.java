package uk.co.aws.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

public class EquityUtility {
	
	public static String formatSequenceNo(String seqId, int len)
	{
		int seqLen = len - seqId.length();
		
		String seqIdTemp = "";
		if(seqLen != 0)
		{
			for(int i = 0 ; i < seqLen; i++ )
				seqIdTemp += "0";
		}
		seqId = seqIdTemp + seqId;
		
		return seqId;
	}
	
	public static String dateFormatInYYmm(String dateString)
	{
		String returnDt = "9999";
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat yyMMformat = new SimpleDateFormat("yyMM");
		Date date = null;
		try {
			date = format.parse(dateString);
			returnDt = yyMMformat.format(date);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnDt;
	}
	
	public static String dateFormatInYYYYmmdd(String dateString)
	{
		String returnDt = "99999999";
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat yyMMformat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = format.parse(dateString);
			returnDt = yyMMformat.format(date);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnDt;
	}
	
	public static void moveFile(String inputFolder, String outputFolder, String filename) throws IOException
	{
		File srcFile = new File(inputFolder + "/" + filename);
	   	File destFile = new File(outputFolder + "/" + filename );
	   	try
	   	{
	   		FileUtils.copyFile(srcFile, destFile);	   		
	   	}
	   	catch(Exception e)
	   	{	
	   		//e.printStackTrace();
	   		System.out.println("************************** ESB not able to move file *********************************:"+outputFolder + "/" + filename);
	   	}
	}
	
	public static String moveFile1(String inputFolder, String outputFolder, String filename) throws IOException
	{			
		//Path sourceFile = Paths.get(inputFolder + "/" + filename);
	    //Path destinationFile = Paths.get(outputFolder + "/" + filename);
	   	   
		//Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);
		
		File srcFile = new File(inputFolder + "/" + filename);
	   	File destFile = new File(outputFolder + "/" + filename );
	   	try
	   	{
	   		FileUtils.copyFile(srcFile, destFile);
	   		filename = "";
	   	}
	   	catch(Exception e)
	   	{	
	   		e.printStackTrace();
	   		System.out.println("************************** ESB not able to move file *********************************:"+outputFolder + "/" + filename);
	   	}
	   	return filename;
	}
	
	public static String moveFile2(String inputFolder, String outputFolder, String filename, String destinationFile) throws IOException
	{
		//Path sourceFile = Paths.get(inputFolder + "/" + filename);
	    //Path destinationFile = Paths.get(outputFolder + "/" + filename);

		//Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);

		//String destinationFile = filename.substring(0,filename.indexOf('_'));

		File srcFile = new File(inputFolder + "/" + filename);
	   	File destFile = new File(outputFolder + "/" + destinationFile);
	  
	   	try
	   	{
	   		FileUtils.copyFile(srcFile, destFile);
	   		filename = "";
	   	}
	   	catch(Exception e)
	   	{
	   		e.printStackTrace();
	   		System.out.println("************************** ESB not able to move file *********************************:"+outputFolder + "/" + filename);
	   	}
	   	return filename;
}
	
	public static void moveErrorFile(String inputFolder, String outputFolder, String filename) throws IOException
	{
		String fn = filename;	    
	    fn = fn.substring(0, fn.indexOf('.'));
	    
		File dir = new File(inputFolder);
		Collection<File> c = FileUtils.listFiles(dir, new WildcardFileFilter(fn+"*.*"), null);
		for(File f1 : c)
        {	
			Path sourceFile = Paths.get(inputFolder + "/" + f1.getName());
		    Path destinationFile = Paths.get(outputFolder + "/" + f1.getName());
		   	   
			Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);
        }
	}
	
	public static String removeExtension (String str) {
		if (str == null) 
			return null;
		
		int pos = str.lastIndexOf(".");

		if (pos == -1) 
			return str;
		else
			return str.substring(0, pos);

	}
	
	public static String[] getFileStartWith(final String startWith, String folder)
	{
		File f = new File(folder);
		String[] allFiles = f.list(new FilenameFilter() {
            public boolean accept(File dir, String fileName) {
                return fileName.startsWith(startWith);
              }
            });
		return allFiles;
	}
	
	public static void moveErrorXmlFile(String processedFolder, String outputFolder,  String xmlName) throws IOException
	{
		//System.out.println("************************** ESB xml file *********************************:"+xmlName);
		
		final String fileToMove = removeExtension(xmlName);
		String[] allFiles = getFileStartWith(fileToMove, processedFolder);
		
		for(String fn : allFiles)
		{
			File srcFile = new File(processedFolder + "/" + fn);
			File destFile = new File(outputFolder + "/" + fileToMove + ".XML" );
			
			try
			{
				FileUtils.copyFile(srcFile, destFile);
			}
			catch(Exception e)
			{
				System.out.println("************************** ESB not able to move file *********************************:"+xmlName);
			}
		}
	}
	
	public static void deletePdfFile(String inputFolder, String filename, String delimiter) throws IOException
	{
		String fn = filename;
		int i = fn.indexOf('-');
		if(i > 0)
			fn = fn.substring(0, fn.indexOf('-'));
		else
			fn = fn.substring(0, fn.indexOf('_'));

	    File dir = new File(inputFolder);
	    Collection<File> c = FileUtils.listFiles(dir, new WildcardFileFilter(fn+"*.*"), null);
	    for(File f1 : c)
        {
	    	if(f1.exists())
	    	f1.delete();
        }
	}
	
	
	
	public static void deleteFiles(String inputFolder) throws IOException
	{		
		FileUtils.cleanDirectory(new File(inputFolder));
	}
	
	public static void unzipFile(String inputFolder, String outputFolder, String filename) throws IOException
	{		
		File srcFile = new File(inputFolder + "/" + filename);
		File destFile = new File(outputFolder + "/" + filename );
		try
		{	   	
			if(srcFile.exists())
			{
				String sourceZipFile = inputFolder + "\\"+filename;
				String outputFolder1 = outputFolder + "\\";

				try {
					
					

					net.lingala.zip4j.core.ZipFile zip = new net.lingala.zip4j.core.ZipFile(sourceZipFile);  
					zip.extractAll(outputFolder1);  					
				} catch (Exception e) { 
					System.out.println("************************** ESB not able to unzip file *********************************:"+filename);
					e.printStackTrace();  
				} //try block ends ehre
			}

		}
		catch(Exception e)
		{
			System.out.println("************************** ESB not able to move file *********************************:"+filename);
		}
	}
	
	public static void deleteFileExtnType(String inputFolder, String filename) throws IOException
	{
		   
		//System.out.println(inputFolder+":"+filename);
		String filestart = filename.substring(0, filename.indexOf('.'));
				
		if(filename.endsWith("PDF"))
		{
			File dir = new File(inputFolder);
			Collection<File> c = FileUtils.listFiles(dir, new WildcardFileFilter(filestart+"*.*"), null);
			for(File f1 : c)
			{	    
				f1.delete();
			}
		}
		else
			new File(inputFolder+"\\"+filename).delete();
	}
	
	public static void deleteFile(String fileName, String folder)
	{
		File file = new File(folder + "/" + fileName);
		
		if(file.exists())
			file.delete();
	}
	
	public static ArrayList getFiles(String zipFolder) throws IOException
	{
		ArrayList<String> arlFiles = new ArrayList<String>();
		
		Path path = Paths.get(zipFolder);
		try (DirectoryStream<Path>  directory =  Files.newDirectoryStream(path))   // Closes stream at the end (ARM)
		{
			for (Path file :  directory) 
				arlFiles.add(file.getFileName().toString());
					
		}		
		
		return arlFiles;
	}
	
	public static byte[] readFile(String folder, String filename) throws Exception
	{
		
		File file = new File(folder + "/" + filename);
		
		byte[] bFile = new byte[(int) file.length()];

		try
		{
			if(file.exists())
			{
				Path path = Paths.get(folder + "/" + filename);
				bFile = Files.readAllBytes(path);
			}
			else
			{
				System.out.println("***** ESB not able to find file ****:"+folder+"/"+filename);
				throw new FileNotFoundException("java.io.FileNotFoundException:"+folder+"/"+filename); 
			}
		}
		catch(Exception e)
		{
			System.out.println("***** ESB unexpected read error *****:"+folder+"/"+filename);
			throw e;
		}
		
		return bFile;
		
	}
	
	
	
	
	public static void deleteFiles(String folderName, String extension) {		
		File folder = new File(folderName);		
		for (File f : folder.listFiles()) {
		    if (f.getName().endsWith(extension)) {
		        f.delete(); 
		    }
		}
	}
}
