package com.groos.monitoring.agent.client.dto;

import java.util.List;

import org.hyperic.sigar.CpuInfo;

public class Monitoring {

	private List<CpuInfo> cpuInfoList;

	public List<CpuInfo> getCpuInfoList() {
		return cpuInfoList;
	}

	public void setCpuInfoList(List<CpuInfo> cpuInfoList) {
		this.cpuInfoList = cpuInfoList;
	} 
	 
}
