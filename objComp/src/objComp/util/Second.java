package objComp.util;

public class Second{
	private double doubleValue;
	private int intValue;
	public Second(){}

	public void setIntValue(int iIn){
		intValue = iIn;
	}

	public void setDoubleValue(double dIn){
		doubleValue = dIn;
	}
	
	public int getIntValue(){
		return intValue;
	}

	public double getDoubleValue(){
		return doubleValue;
	}

	@Override
	public boolean equals(Object o){
		if(o == this){
			return true;
		}
		if(!(o instanceof Second)){
			return false;
		}
		Second temp = (Second)o;
		return (intValue == temp.getIntValue()) && (doubleValue == temp.getDoubleValue());
	}

	@Override
	public int hashCode(){
		int hash = 7;
		hash = hash + intValue;
		hash = hash + Double.valueOf(doubleValue).hashCode();
		return hash;
	}
}
