package com.groos.monitoring.agent;

import java.util.concurrent.Executors;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;

import com.groos.monitoring.agent.communicate.HeartbeatCommunicaterThread;

public class AgentDaemon implements Daemon {
 

	@Override
	public void init(DaemonContext context) throws DaemonInitException, Exception { 
		
	}

	@Override
	public void start() throws Exception {
 
		
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
