package objComp.util;

import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.ClassNotFoundException;
import java.lang.InstantiationException;
import java.lang.NoSuchMethodException;
import java.lang.IllegalAccessException;

import objComp.fileOperations.FileProcessor;

public class PopulateObjects{
	private HashMap<First,Integer> firstMap;
	private HashMap<Second,Integer> secondMap;
	private HashMap<String,Class> typeMap;
	private FileProcessor processor;

	MyLogger logger = MyLogger.getInstance();
	
	public PopulateObjects(FileProcessor pIn){
		firstMap = new HashMap<First,Integer>();
		secondMap = new HashMap<Second,Integer>();
		typeMap = new HashMap<String,Class>();
		processor = pIn;
		typeMap.put("int",Integer.TYPE);
		typeMap.put("double",Double.TYPE);
		typeMap.put("String",String.class);
		logger.printMessage(2, "PopulateObjects constructor");
		logger.printMessage(2, "PopulateObjects");
	}
	
	public void addFirst(First fIn){
		logger.printMessage(1, "addFirst() in PopulateObjects");
		logger.printMessage(2, "addFirst() called in PopulateObjects");
		if(firstMap.containsKey(fIn)){
			firstMap.put(fIn,firstMap.get(fIn)+1);
		}
		else{
			firstMap.put(fIn,1);
		}
	}
	
	public void addSecond(Second sIn){
		logger.printMessage(1, "addSecond() in PopulateObjects");
		logger.printMessage(2, "addSecond() called in PopulateObjects");
		if(secondMap.containsKey(sIn)){
			secondMap.put(sIn,secondMap.get(sIn)+1);
		}
		else{
			secondMap.put(sIn,1);
		}
	}

	public int numNonDuplicateFirst(){
		logger.printMessage(1, "numNonDuplicateFirst() in PopulateObjects");
		return firstMap.size();
	}

	public int numNonDuplicateSecond(){
		logger.printMessage(1, "numNonDuplicateSecond in PopulateObjects");
		return secondMap.size();
	}

	public int totalNumFirst(){
		logger.printMessage(1, "totalNumFirst() in PopulateObjects");
		int total = 0;
		for (int number : firstMap.values()){
			total += number;
		}
		return total;
	}

	public int totalNumSecond(){
		logger.printMessage(1, "totalNumSecond() in PopulateObjects");
		int total = 0;
		for (int number : secondMap.values()){
			total += number;
		}

		return total;
	}

	public void printInfo(){
		logger.printMessage(1, "printInfo() in PopulateObjects");
		System.out.println("Number of non-duplicate First objects: " + numNonDuplicateFirst());
		System.out.println("Total Number of First objects: " + totalNumFirst());
		System.out.println("Number of non-duplicate Second objects: " + numNonDuplicateSecond());
		System.out.println("Total Number of Second objects: " + totalNumSecond());
	}
	
	public void deserObjects(){
		logger.printMessage(1, "deserObjects in PopulateObjects");
		String inputHolder;
		String clsName;
		Class cls;
		Class[] signature = new Class[1];
		String methName;
		Method meth;
		Object obj;
		Object[] params = new Object[1];
		Object result;

		String inputType;
	
		String classNameRE = "fqn:(.*)";
		Pattern classPattern = Pattern.compile(classNameRE);
		String variablesRE = "type=(.*), var=(.*), value=(.*)";
		Pattern variablePattern = Pattern.compile(variablesRE);
		Matcher m;
		
		inputHolder = processor.getNextLineFromFile();
		while(inputHolder != "No lines left"){
			try{
				if(inputHolder != ""){
					m = classPattern.matcher(inputHolder);
					m.matches();
					clsName = m.group(1);
					cls = Class.forName(clsName);
					obj = cls.newInstance();

					inputHolder = processor.getNextLineFromFile();
					while(inputHolder == ""){
						inputHolder = processor.getNextLineFromFile();
					}
				
					m = variablePattern.matcher(inputHolder);
					m.matches();
					signature[0] = typeMap.get(m.group(1));
					methName = "set" + m.group(2);
					meth = cls.getMethod(methName, signature);
					if(m.group(1).equals("int")){
						params[0] = Integer.parseInt(m.group(3));
					}
					else if(m.group(1).equals("double")){
						params[0] = Double.parseDouble(m.group(3));
					}
					else{
						params[0] = new String(m.group(3));
					}
					meth.invoke(obj,params);
					
					inputHolder = processor.getNextLineFromFile();
					while(inputHolder == ""){
						inputHolder = processor.getNextLineFromFile();
					}
				
					m = variablePattern.matcher(inputHolder);
					m.matches();
					signature[0] = typeMap.get(m.group(1));
					methName = "set" + m.group(2);
					meth = cls.getMethod(methName, signature);
					if(m.group(1).equals("int")){
						params[0] = Integer.parseInt(m.group(3));
					}
					else if(m.group(1).equals("double")){
						params[0] = Double.parseDouble(m.group(3));
					}
					else{
						params[0] = new String(m.group(3));
					}
					meth.invoke(obj,params);
					
					if(clsName.endsWith("First")){
						addFirst((First)obj);
					}
					else{
						addSecond((Second)obj);
					}
				}
			}
			catch(ClassNotFoundException e){
				System.err.println("Some Class was not found");
				System.exit(0);
			}
			catch(InstantiationException e){
				System.err.println("Error Instantiating Class");
				System.exit(0);
			}
			catch(IllegalAccessException e){
				System.err.println("Some Problem with Class or Method Permissions");
				System.exit(0);
			}
			catch(NoSuchMethodException e){
				System.err.println("Incorrect Method Name Detected");
				System.exit(0);
			}
			catch(InvocationTargetException e){
				System.err.println("Error Invoking a Method");
				System.exit(0);
			}
			inputHolder = processor.getNextLineFromFile();
		}
		
	}
}
