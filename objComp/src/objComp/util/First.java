package objComp.util;

public class First{
	
	private int intValue;
	private String stringValue;
	
	public First(){}
	
	public void setIntValue(int iIn){
		intValue = iIn;
	}

	public void setStringValue(String sIn){
		stringValue = sIn;
	}

	public int getIntValue(){
		return intValue;
	}

	public String getStringValue(){
		return stringValue;
	}


	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(!(o instanceof First)){
			return false;
		}
		First temp = (First)o;
		return (intValue == temp.getIntValue()) && (stringValue == temp.getStringValue());
	}

	@Override
	public int hashCode(){
		int hash = 5;
		hash = hash + intValue;
		hash = hash + (stringValue != null ? stringValue.hashCode() : 0);
		return hash;
	}	
}
