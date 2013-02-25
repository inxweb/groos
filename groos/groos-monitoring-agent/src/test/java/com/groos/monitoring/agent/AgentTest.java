package com.groos.monitoring.agent;

import static org.junit.Assert.fail;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.groos.monitoring.agent.client.dto.CommandRequest;
import com.groos.monitoring.agent.client.dto.Heartbeat;
import com.groos.monitoring.agent.client.dto.HeartbeatResult;
import com.groos.monitoring.agent.client.endpoint.HeartbeatEndpoint;
import com.groos.monitoring.agent.communicate.HeartbeatCommunicaterThread;
 

public class AgentTest {
//	
//	private Thread communicaterThread;
//	
//	private HeartbeatEndpoint endpoint; 
//	
//	private BlockingQueue<CommandRequest> queue;
//	
//	@Before
//	public void setUp() { 
//		
//	}
//	 
//
//	@SuppressWarnings("static-access")
//	@Test
//	public void testStart() throws InterruptedException {
//		this.endpoint = new HeartbeatEndpoint() {
//			
//			@Override
//			public HeartbeatResult sendHeartbeat(Heartbeat heartbeat) {
//				System.out.println(heartbeat);
//				return new HeartbeatResult();
//			}
//			
//		};
//		
//		this.queue = new ArrayBlockingQueue<CommandRequest>(100);
//		
//		this.communicaterThread = Executors.defaultThreadFactory().newThread(new HeartbeatCommunicaterThread(endpoint, queue));
//		
//		communicaterThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() { 
//			@Override
//			public void uncaughtException(Thread t, Throwable e) {
//				  
//				 
//			}
//			
//		});
//		
//		communicaterThread.start(); 
//		
//		communicaterThread.join(); 
//		
//	}
//
//	@Test @Ignore
//	public void testShutdown() {
//		fail("Not yet implemented");
//	}

}
