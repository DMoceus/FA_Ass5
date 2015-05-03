package objComp.util;

import java.util.HashMap;

public class PopulateObjects{
	private HashMap<First,Integer> firstMap;
	private HashMap<Second,Integer> secondMap;
	
	public PopulateObjects(){
		firstMap = new HashMap<First,Integer>();
		secondMap = new HashMap<Second,Integer>();
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
}
