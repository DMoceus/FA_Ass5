package objComp.util;

public class First{
	
	private int IntValue;
	private String StringValue;

	MyLogger logger = MyLogger.getInstance();
	
	public First(){
		logger.printMessage(2, "First");
	}
	
	public void setIntValue(int iIn){
		logger.printMessage(1, "setIntValue() in First");
		IntValue = iIn;
	}

	public void setStringValue(String sIn){
		logger.printMessage(1, "setStringValue() in First");
		StringValue = sIn;
	}

	public int getIntValue(){
		logger.printMessage(1, "getIntValue() in First");
		return IntValue;
	}

	public String getStringValue(){
		logger.printMessage(1, "getStringValue() in First");
		return StringValue;
	}


	@Override
	public boolean equals(Object o){
		logger.printMessage(1, "equals() in First");
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
		logger.printMessage(1, "hashCode() in First");
		int hash = 5;
		hash = hash + IntValue;
		hash = hash + (StringValue != null ? StringValue.hashCode() : 0);
		return hash;
	}	
}
