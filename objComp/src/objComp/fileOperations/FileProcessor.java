package objComp.fileOperations;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import objComp.util.MyLogger;

public class FileProcessor{
	Scanner sc;
	String inputFile = "";
	
	MyLogger logger = MyLogger.getInstance();

	public FileProcessor(String inFileName){
		inputFile = inFileName;
		try{
			logger.printMessage(2, "FileProcessor");
			sc = new Scanner(new File(inFileName));
		} catch (FileNotFoundException e){
			System.out.println("FileProcessor has thrown a FileNotFoundException. inputFile does not exist. Exiting program.");
			System.exit(1);
		}
		
	}


	public String getNextLineFromFile(){
		logger.printMessage(1, "getNextLineFromFile() in FileProcessor");
		if (sc.hasNextLine()){
			return sc.nextLine();
		} else{
			return "No lines left";
		}
	}

	public String getNextFromFile(){
		logger.printMessage(1, "getNextFromFile in FileProcessor");
		if(sc.hasNext()){
			return sc.next();
		}
		else{
			return "No Lines Left";
		}
	}

	public boolean hasNextFromFile(){
		logger.printMessage(1, "hasNextFromFile() in FileProcessor");
		return sc.hasNext();
	}

}
