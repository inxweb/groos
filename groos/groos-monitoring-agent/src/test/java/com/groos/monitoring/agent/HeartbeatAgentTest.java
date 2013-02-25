package com.groos.monitoring.agent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;

import com.groos.monitoring.agent.client.dto.CommandRequest;
import com.groos.monitoring.agent.client.dto.CommandResult;
import com.groos.monitoring.agent.client.dto.Heartbeat;
import com.groos.monitoring.agent.client.dto.HeartbeatResult;
import com.groos.monitoring.agent.client.endpoint.HeartbeatEndpoint;
import com.groos.monitoring.agent.cmd.CommandExecutorThread;
import com.groos.monitoring.agent.communicate.HeartbeatCommunicaterThread;

public class HeartbeatAgentTest {

	private Thread communicaterThread;
	
	private Thread commandExecutorThread;
	
	private HeartbeatEndpoint endpoint; 
	
	private BlockingQueue<CommandRequest> queue;
	
	private Queue<CommandResult> resultQueue;
	
	@Before
	public void setUp() { 
		this.endpoint = new HeartbeatEndpoint() {
			
			@Override
			public HeartbeatResult sendHeartbeat(Heartbeat heartbeat) {
				if(heartbeat != null) {
					for(CommandResult result : heartbeat.getCommandResultList()) {
						System.out.println(result);
					}
				}
				
				
				CommandRequest request = new CommandRequest();
				
				request.setDirectory("/project-env/tmp");
				
				request.setCommandList(Arrays.asList("cmd", "/c", "test.bat"));
				
				List<CommandRequest> commandRequestList = Arrays.asList(request);  
				
				HeartbeatResult result = new HeartbeatResult();
				
				result.setCommandRequestList(commandRequestList); 
				
				return result;
			}
			
		};
		
		this.queue = new ArrayBlockingQueue<CommandRequest>(100);
		
		this.resultQueue = new LinkedList<CommandResult>();
		
		this.communicaterThread = Executors.defaultThreadFactory().newThread(new HeartbeatCommunicaterThread(endpoint, queue, resultQueue));  
		
		this.commandExecutorThread = Executors.defaultThreadFactory().newThread(new CommandExecutorThread(queue, resultQueue)); 
		

		
	
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testStart() throws InterruptedException { 
		
		this.commandExecutorThread.start();
		
		this.communicaterThread.start();  
		
		try {
			this.communicaterThread.join();
		} catch (InterruptedException e) { 
			e.printStackTrace();
		} 
		
		
	}

}
