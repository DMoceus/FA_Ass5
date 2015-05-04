package objComp.util;

import java.util.HashMap;
import objComp.fileOperations.FileProcessor;

public class PopulateObjects{
	private HashMap<First,Integer> firstMap;
	private HashMap<Second,Integer> secondMap;
	private FileProcessor processor;
	
	public PopulateObjects(FileProcessor pIn){
		firstMap = new HashMap<First,Integer>();
		secondMap = new HashMap<Second,Integer>();
		processor = pIn;
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
		String clsName;
		Class cls;
		Class[] signature = new Class[1];
		String methName;
		Method meth;
		Object obj;
		Object[] params = new Object[1];
		Object result;

		
		
	}
}
