package com.groos.monitoring.agent.collect;

import java.util.concurrent.BlockingQueue;

import com.groos.monitoring.agent.client.dto.Monitoring;

public class HardwareCollectorThead implements Runnable {
 
	private BlockingQueue<Monitoring> queue; 
	
	private CpuInfoCollector cpuInfoCollector;
	
	private Boolean running = true;
	
	private HardwareCollectorThead(BlockingQueue<Monitoring> queue) {
		cpuInfoCollector = new CpuInfoCollector();
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(running) { 
			try {
				if(Thread.currentThread().isInterrupted()) {
					running = false;
					continue;
				}
				
				Thread.sleep(5 * 1000);  
				
				Monitoring monitoring = new Monitoring();
				
				monitoring.setCpuInfoList(cpuInfoCollector.findCpuInfoList()); 
				
				queue.put(monitoring); 
				
			} catch (InterruptedException e) { 
				running = false;
			}
		} 
	}

}
