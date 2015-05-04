package objComp.util;

public class First{
	
	private int IntValue;
	private String StringValue;
	
	public First(){}
	
	public void setIntValue(int iIn){
		IntValue = iIn;
	}

	public void setStringValue(String sIn){
		StringValue = sIn;
	}

	public int getIntValue(){
		return IntValue;
	}

	public String getStringValue(){
		return StringValue;
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
		return (IntValue == temp.getIntValue()) && (StringValue == temp.getStringValue());
	}

	@Override
	public int hashCode(){
		int hash = 5;
		hash = hash + IntValue;
		hash = hash + (StringValue != null ? StringValue.hashCode() : 0);
		return hash;
	}	
}
