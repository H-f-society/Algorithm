/*
* @Author: root
* @Date:   2019-11-21 22:00:32
* @Last Modified by:   root
* @Last Modified time: 2020-02-10 19:05:29
*/
//list()列出文件夹全部内容，列出名字
//listFile()列出完整路径
import java.io.*;
import java.util.*;

public class CountFilesRow{
	public static String findFolder = "F:/Code/";
	public static int maxRowsLimit = 600;
	public static int fileNum  = 0;
	public static int filesRowNum = 0;
	public static Map<String, Boolean> map = new HashMap<>();
	public static String[] fileType = {"html", "css", "js", "java", "py", "php", "cpp", "sh", ".net"};

	public static void main(String[] args){
		Long startTime, endTime;
		for(String key : fileType) {
			map.put(key, true);
		}

		startTime = System.nanoTime();
		getFilesUrl(findFolder);
		endTime = System.nanoTime();
		System.out.println("\nrunTime: " + (endTime - startTime) + "ns");

		System.out.println("Total number of documents : " + fileNum);
		System.out.println("Total number of files row : " + filesRowNum);
	}
	public static void getFilesUrl(String fileUrl) {
		File file = new File(fileUrl);

		File files[] = file.listFiles();
		for(int i=0; i<files.length; i++){
			File isFile = new File(files[i]+"");
			if(isFile.isDirectory()){
				getFilesUrl(isFile.getPath());
			}else{
				if(getFileType(files[i] + "")) {
					System.out.print(files[i]);
					fileRow(files[i] + "");	

					fileNum++;
				}
			}
		}
	}
	public static void fileRow(String fileUrl) {
		try {
			File file =new File(fileUrl);
			if(file.exists()){
			    FileReader fr = new FileReader(file);
			    LineNumberReader lnr = new LineNumberReader(fr);
			    int linenumber = 0;
	            while (lnr.readLine() != null){
	        		linenumber++;
	            }
	            if(linenumber < maxRowsLimit) {
	            	filesRowNum = filesRowNum + linenumber;
	            }
	            System.out.print(" : " + linenumber + "\n");
	            lnr.close();
			}else{
				System.out.println("File does not exists!");
			}
		}catch(IOException e){
    		e.printStackTrace();
    	}
	}
	public static boolean getFileType(String fileUrl) {
		File file = new File(fileUrl);
		String fileName = file.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		return map.get(suffix)!=null ? true : false;
	}
}