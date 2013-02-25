package com.groos.monitoring.agent.collect;

import java.util.Arrays;
import java.util.List;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class CpuInfoCollector {
	private static Sigar sigar;

	public CpuInfoCollector() {
		sigar = new Sigar();
	}

	public List<CpuInfo> findCpuInfoList() {
		try {
			return Arrays.asList(sigar.getCpuInfoList());
		} catch (SigarException e) {
			throw new RuntimeException(e);
		}  
	} 

}
