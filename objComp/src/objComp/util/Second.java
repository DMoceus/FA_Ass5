package objComp.util;

public class Second{
	private double DoubleValue;
	private int IntValue;
	public Second(){}

	public void setIntValue(int iIn){
		IntValue = iIn;
	}

	public void setDoubleValue(double dIn){
		DoubleValue = dIn;
	}
	
	public int getIntValue(){
		return IntValue;
	}

	public double getDoubleValue(){
		return DoubleValue;
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
		return (IntValue == temp.getIntValue()) && (DoubleValue == temp.getDoubleValue());
	}

	@Override
	public int hashCode(){
		int hash = 7;
		hash = hash + IntValue;
		hash = hash + Double.valueOf(DoubleValue).hashCode();
		return hash;
	}
}
