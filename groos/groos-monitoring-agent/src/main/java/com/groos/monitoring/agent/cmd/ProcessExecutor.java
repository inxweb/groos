package com.groos.monitoring.agent.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import org.apache.commons.io.IOUtils;

public class ProcessExecutor {
	
	private StringWriter stdout; 
	
	private StringWriter stderr; 
	
	private int status; 
	
	private File directory; 
	
	private List<String> commandList = new ArrayList<String>(); 
	
	public String getStdout() {
		return stdout.toString();
	}

	public String getStderr() {
		return stderr.toString();
	}

	public int getStatus() {
		return status;
	}

	public ProcessExecutor() {
		
	}
	 
	public ProcessExecutor directory(File directory) {
		this.directory = directory;
		return this;
	}
	
	public ProcessExecutor commandList(List<String> commandList) {
		this.commandList.addAll(commandList);
		return this;
	}
	
	public ProcessExecutor command(String command) {
		this.commandList.add(command);
		return this;
	}
	
	public ProcessExecutor execute() throws Exception {  
		
		ProcessBuilder processBuilder = new ProcessBuilder(commandList);
		
		if(directory != null) {
			processBuilder.directory(directory);
 
		}  
 
		Process process = processBuilder.start();
		
		stdout = new StringWriter();
		
		stderr = new StringWriter();
		
		Thread stdoutReader = Executors.defaultThreadFactory().newThread(new StreamReader(process.getInputStream(), new PrintWriter(stdout, true)));
		
		Thread stderrReader = Executors.defaultThreadFactory().newThread(new StreamReader(process.getErrorStream(), new PrintWriter(stderr, true))); 
		
		stdoutReader.start();
		
		stderrReader.start();
		
		status = process.waitFor(); 
		
		return this;
	}
	
	public static class StreamReader implements Runnable {
		
		private InputStream inputStream;
		
		private PrintWriter printWriter;
		
		private StreamReader(InputStream inputStream, PrintWriter printWriter) {
			this.inputStream = inputStream;
			this.printWriter = printWriter; 
		}

		@Override
		public void run() {
			BufferedReader bufferedReader = null;
			
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				
				String line = null;
				
	            while ((line = bufferedReader.readLine()) != null) {
	            	printWriter.println(line);
	            }
	            
			} catch (Exception e) {
				 
			} finally {
				IOUtils.closeQuietly(inputStream);
				IOUtils.closeQuietly(printWriter);
			} 
		} 
	}
}
