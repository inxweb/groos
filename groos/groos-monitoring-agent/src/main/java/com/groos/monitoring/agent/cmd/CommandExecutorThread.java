package com.groos.monitoring.agent.cmd;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import com.groos.monitoring.agent.client.dto.CommandRequest;
import com.groos.monitoring.agent.client.dto.CommandResult;

public class CommandExecutorThread implements Runnable {
	private BlockingQueue<CommandRequest> requestQueue; 
	
	private Queue<CommandResult> resultQueue;
	
	public CommandExecutorThread(BlockingQueue<CommandRequest> requestQueue, Queue<CommandResult> resultQueue) {
		this.requestQueue = requestQueue;
		this.resultQueue = resultQueue;
	}
	 
	@Override
	public void run() {
		
		while(!Thread.currentThread().isInterrupted()) {
			try {
				CommandRequest commandRequest = requestQueue.take();
				
				CommandResult commandResult = new CommandResult();
				
				try {
					ProcessExecutor processExecutor = new ProcessExecutor()
							.directory(new File(commandRequest.getDirectory()))
							.commandList(commandRequest.getCommandList())
							.execute();
					
					
					commandResult.setStatus(processExecutor.getStatus());
					commandResult.setSuccessMessage(processExecutor.getStdout());
					commandResult.setErrorMessage(processExecutor.getStderr());
					
				} catch (Exception e) {
					commandResult.setStatus(-2);
					commandResult.setErrorMessage(e.getMessage());
				}  
				System.out.println("XXXXXX");
				synchronized (resultQueue) {
					resultQueue.offer(commandResult);
					
				}
				System.out.println("YYYYYY");
				
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}  
		} 
	}

}
