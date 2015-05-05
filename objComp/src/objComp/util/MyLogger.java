package objComp.util;

public class MyLogger{
	private static MyLogger instance = null;

	private static final int DEFAULT = 0;
	private static final int METHOD = 1;
	private static final int MODIFY_HASH = 2;
	private static final int CONSTRUCTOR = 3;


	private static int DEBUG_VALUE = 0;
	
	protected MyLogger(){}

	public void setDebugValue(int value){
		if((value >= DEFAULT) && (value <= CONSTRUCTOR)){
			DEBUG_VALUE = value;
		}
	}
	
	public static MyLogger getInstance(){
		if(instance == null){
			instance = new MyLogger();
		}
		return instance;
	}

	public void printMessage(int value, String message){
		if(DEBUG_VALUE == value){
			if(METHOD == DEBUG_VALUE){
				System.out.println("Method Called: " + message);
			}
			else if(MODIFY_HASH == DEBUG_VALUE){
				System.out.println("Data structure modified: " + message);
			}
			else if (CONSTRUCTOR == DEBUG_VALUE){
				System.out.println(message + "'s constructor has been called");
			}
		}
	}
}
