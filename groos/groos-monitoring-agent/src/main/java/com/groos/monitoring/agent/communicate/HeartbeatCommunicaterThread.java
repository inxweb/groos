package com.groos.monitoring.agent.communicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import org.springframework.util.CollectionUtils;

import com.groos.monitoring.agent.client.dto.CommandRequest;
import com.groos.monitoring.agent.client.dto.CommandResult;
import com.groos.monitoring.agent.client.dto.Heartbeat;
import com.groos.monitoring.agent.client.dto.HeartbeatResult;
import com.groos.monitoring.agent.client.endpoint.ClientSideException;
import com.groos.monitoring.agent.client.endpoint.HeartbeatEndpoint;
import com.groos.monitoring.agent.client.endpoint.ServerSideException;

public class HeartbeatCommunicaterThread implements Runnable {
	private HeartbeatEndpoint endpoint;  
	
	private BlockingQueue<CommandRequest> requestQueue;
	
	private Queue<CommandResult> resultQueue;
	
	private List<CommandResult> commandResultList;
	
	public HeartbeatCommunicaterThread(HeartbeatEndpoint endpoint, BlockingQueue<CommandRequest> requestQueue, Queue<CommandResult> resultQueue) {
		super();
		this.endpoint = endpoint; 
		this.requestQueue = requestQueue;
		this.resultQueue = resultQueue; 
		this.commandResultList = new ArrayList<CommandResult>();
	}
	
	@Override
	public void run() {   
		while(!Thread.currentThread().isInterrupted()) { 
			try {
				Heartbeat heartbeat = new Heartbeat(); 
				
				setUpCommandRequestList();
				
				heartbeat.setCommandResultList(commandResultList);
					
				HeartbeatResult result = null; 
			
				result = this.endpoint.sendHeartbeat(heartbeat);
				
				this.commandResultList = new ArrayList<CommandResult>(); 

				if(!CollectionUtils.isEmpty(result.getCommandRequestList())) {
					for(CommandRequest request : result.getCommandRequestList()) { 
						requestQueue.put(request); 
					}
				}  
			
				Thread.sleep(3 * 1000);
				
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				
			}  catch (ServerSideException e) { 
				e.printStackTrace();
				
			} catch (ClientSideException e) { 
				e.printStackTrace(); 
			}
		} 
	}
	
	private void setUpCommandRequestList() { 
		
		synchronized (resultQueue) {
			CommandResult commandResult = null;
			
			while(true) { 
				commandResult = resultQueue.poll();
				
				if(commandResult == null) {
					break;
				}
				
				commandResultList.add(commandResult); 
			} 
		}
	}
}
