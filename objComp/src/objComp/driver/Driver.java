package objComp.driver;

import objComp.fileOperations.FileProcessor;
import objComp.util.PopulateObjects;
import objComp.util.MyLogger;

public class Driver{

	private static int NUM_ITERATIONS = 0;
	private static int DEBUG_VALUE = 0;

	MyLogger logger = MyLogger.getInstance();

	public static void main(String args[]){
		long startTime = System.currentTimeMillis();
		PopulateObjects populateObjects;

		String inputFile = args[0];
		NUM_ITERATIONS = Integer.parseInt(args[1]);
		DEBUG_VALUE = Integer.parseInt(args[2]);


		for (int i = 0; i < NUM_ITERATIONS; i++){
			FileProcessor fileProcessor = new FileProcessor(inputFile);
			populateObjects = new PopulateObjects(fileProcessor);
			populateObjects.deserObjects();
			if (i == 0){
				populateObjects.printInfo();
			}
		}

		long finishTime = System.currentTimeMillis();
		long totalTime = (finishTime-startTime)/NUM_ITERATIONS;

		System.out.println("Total Time: " + totalTime);
		
	}
}