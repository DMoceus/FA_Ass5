package objComp.util;

public class Second{
	private double DoubleValue;
	private int IntValue;

	public Second(){
		logger.printMessage(2, "Second");
	}

	MyLogger logger = MyLogger.getInstance();

	public void setIntValue(int iIn){
		logger.printMessage(1, "setIntValue() in Second");
		IntValue = iIn;
	}

	public void setDoubleValue(double dIn){
		logger.printMessage(1, "setDoubleValue() in Second");
		DoubleValue = dIn;
	}
	
	public int getIntValue(){
		logger.printMessage(1, "getIntValue() in Second");
		return IntValue;
	}

	public double getDoubleValue(){
		logger.printMessage(1, "getDoubleValue() in Second");
		return DoubleValue;
	}

	@Override
	public boolean equals(Object o){
		logger.printMessage(1, "equals() in Second");
		if(o == this){
			return true;
		}
		if(!(o instanceof Second)){
			return false;
		}
		Second temp = (Second)o;
		return (IntValue == temp.getIntValue()) && (DoubleValue == temp.getDoubleValue());
	}

	@Override
	public int hashCode(){
		logger.printMessage(1, "hashCode() in Second");
		int hash = 7;
		hash = hash + IntValue;
		hash = hash + Double.valueOf(DoubleValue).hashCode();
		return hash;
	}
}
