package com.groos.common.execption;

import java.util.List;

public class ExceptionType { 
	
	private Class<? extends Exception> clazz;
	
	private List<ExceptionHandler> exceptionHandlerList;
	
	private PostHandlingAction postHandlingAction;

}
