package com.groos.monitoring.agent.communicate;

import java.util.concurrent.BlockingQueue;

import com.groos.monitoring.agent.client.dto.Monitoring;
import com.groos.monitoring.agent.client.dto.Monitoring;
import com.groos.monitoring.agent.client.dto.MonitoringResult;
import com.groos.monitoring.agent.client.endpoint.MonitoringEndpoint;

public class MonitoringCommunicaterThread implements Runnable {
	private MonitoringEndpoint endpoint;
	
	private BlockingQueue<Monitoring> queue;  
	
	private Boolean running = true;
	
	public MonitoringCommunicaterThread(MonitoringEndpoint endpoint, BlockingQueue<Monitoring> queue) {
		super();
		this.endpoint = endpoint;
		this.queue = queue;
	} 


	@Override
	public void run() {
		while(running) { 
			try {
				Monitoring content = queue.take();
				
				Monitoring request = new Monitoring();  
				 
				MonitoringResult response = endpoint.sendMessagee(request); 
				
			} catch (InterruptedException e) {
				running = false;
			} 
		} 
	}
}
