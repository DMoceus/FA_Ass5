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
	
	public PopulateObjects(FileProcessor pIn){
		firstMap = new HashMap<First,Integer>();
		secondMap = new HashMap<Second,Integer>();
		processor = pIn;
		typeMap.put("int",Integer.TYPE);
		typeMap.put("double",Double.TYPE);
		typeMap.put("String",String.class);
	}
	
	public void addFirst(First fIn){
		if(firstMap.containsKey(fIn)){
			firstMap.put(fIn,firstMap.get(fIn)+1);
		}
		else{
			firstMap.put(fIn,1);
		}
	}
	
	public void addSecond(Second sIn){
		if(secondMap.containsKey(sIn)){
			secondMap.put(sIn,secondMap.get(sIn)+1);
		}
		else{
			secondMap.put(sIn,1);
		}
	}
	
	public void deserObjects(){
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
	
		String classNameRE = "/fqn:(.*)/";
		Pattern classPattern = Pattern.compile(classNameRE);
		String variablesRE = "/type=(.*), var=(.*), value=(.*)/";
		Pattern variablePattern = Pattern.compile(variablesRE);
		Matcher m;
		
		inputHolder = processor.getNextLineFromFile();
		while(inputHolder != "No lines left"){
			try{
				if(inputHolder != ""){
					m = classPattern.matcher(inputHolder);
					clsName = m.group(1);
					cls = Class.forName(clsName);
					obj = cls.newInstance();

					inputHolder = processor.getNextLineFromFile();
					while(inputHolder == ""){
						inputHolder = processor.getNextLineFromFile();
					}
				
					m = variablePattern.matcher(inputHolder);
					signature[0] = typeMap.get(m.group(1));
					methName = "set" + m.group(2);
					meth = cls.getMethod(methName, signature);
					params[0] = Integer.parseInt(m.group(3));
					meth.invoke(obj,params);
					
					inputHolder = processor.getNextLineFromFile();
					while(inputHolder == ""){
						inputHolder = processor.getNextLineFromFile();
					}
				
					m = variablePattern.matcher(inputHolder);
					signature[0] = typeMap.get(m.group(1));
					methName = "set" + m.group(2);
					meth = cls.getMethod(methName, signature);
					if(m.group(1) == "double"){
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
