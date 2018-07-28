package com.zagula.JPK;

public class Logger {
	
 	
	private Logger() {
		
	}
	
	
//	private String marta = null;
//	
//	private static Logger instance = null;
//	
//	public static Logger getInstance() {
//		if(instance == null) {
//			instance = new Logger();
//		}
//		return instance;
//	}
//	
	public static void logError(String pole, int lineNumber, String info , String value, String additionalInfo) {
	
		System.out.println("Check column(s) " + pole + " at line " + lineNumber + ". Error: " + info +" Value is [" + value + "]. "+ additionalInfo);
		
		
	}
	
//	public void setMarta(String marta) {
//		this.marta = marta;
//	}
//	
//	public String getMarta() {
//		return this.marta;
//	}

}
