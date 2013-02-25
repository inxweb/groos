package com.groos.monitoring.agent;

import com.groos.monitoring.agent.client.endpoint.HeartbeatEndpoint;

public class HeartbeatAgent {
	
	private Thread communicaterThread; 
	
	private Thread commandExecutorThread;
	
	private HeartbeatEndpoint endpoint; 
	
	private AgentConfiguration agentConfiguration;
 
	public HeartbeatAgent() {
		super(); 
	}

	public HeartbeatAgent(AgentConfiguration agentConfiguration, Thread communicaterThread, Thread commandExecutorThread, HeartbeatEndpoint endpoint) {
		super();
		this.agentConfiguration = agentConfiguration;
		this.communicaterThread = communicaterThread;
		this.commandExecutorThread = commandExecutorThread;
		this.endpoint = endpoint;
	}

	public void start() { 
		commandExecutorThread.start();
		communicaterThread.start();
		
	}
	
	public void shutdown() {
		commandExecutorThread.interrupt();
		communicaterThread.interrupt();
	} 
}
