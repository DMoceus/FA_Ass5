package objComp.fileOperations;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

//import wordCount.util.MyLogger;

//import taskManager.util.MyLogger;
/**
* FileProcessor.java
*
* Class containing methods to read from a file and write to a file.
*
* @author Adam Almonte <aalmont4>
*/
public class FileProcessor{
	Scanner sc;
	String inputFile = "";
	String outputFile = "";
	
//	MyLogger logger;

	//MyLogger logRef = MyLogger.getInstance();

	/**
	* Constructor for FileProcessor
	* @param inFileName - the file to read from
	* @param outFileName - the file to write to
	*/
	public FileProcessor(String inFileName, String outFileName){
		inputFile = inFileName;
		outputFile = outFileName;
//		logger = MyLogger.getInstance();
//		logger.printMessage(1);
		try{
			sc = new Scanner(new File(inFileName));

		} catch (FileNotFoundException e){
			//logRef.printMessage(0, "FileProcessor has thrown a FileNotFoundException. inputFile does not exist. Exiting program.");
			System.exit(1);
		}// catch (IOException e){
			//logRef.printMessage(0, "FileProcessor has thrown an IOException. Error trying to write to file. Exiting program.");
			System.exit(1);
		//}
		
	}

	/**
	* Gets the next line from the input file
	* @return Either the next line in the file, or the string "No lines left", signifying that the end of the file
	*	has been reached
	*/
	public String getNextLineFromFile(){
		//logRef.printMessage(3, "getNextLineFromFile() called");
		if (sc.hasNextLine()){
			return sc.nextLine();
		} else{
			return "No lines left";
		}
	}

	public String getNextFromFile(){
		if(sc.hasNext()){
			return sc.next();
		}
		else{
			return "No Lines Left";
		}
	}

	public boolean hasNextFromFile(){
		return sc.hasNext();
	}

	/**
	* Appends a line to the end of the output file.
	* @param line - the line to be written
	* @param printNewLine - if true, a newline character will be inserted at the end of line. 
	*/
	public void writeLineToFile(String line, boolean printNewLine){
		//logRef.printMessage(3, "writeLineToFile() called");
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
			bw.write(line);
			if(printNewLine == true){
				bw.newLine();
			}
			bw.close();
		} catch (IOException e){
			//System.out.println("Error in FileProcessor: IOException writing to file.");
			//logRef.printMessage(0, "FileProcessor has thrown an IOException. Error trying to write to file. Exiting program.");
			System.exit(1);
		}
	}

}
