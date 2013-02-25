package com.groos.monitoring.agent;

import com.groos.monitoring.agent.client.endpoint.MonitoringEndpoint;


public class MonitoringAgent {
	
	private Thread communicaterThread; 
	
	private MonitoringEndpoint endpoint; 
 
	public MonitoringAgent() {
		super();
	}

	public MonitoringAgent(Thread communicaterThread, MonitoringEndpoint endpoint) {
		super();
		this.communicaterThread = communicaterThread;
		this.endpoint = endpoint;
	}

	public void start() { 
		communicaterThread.start();
		
	}
	
	public void shutdown() {
		communicaterThread.interrupt();
	} 
}
