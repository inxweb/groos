package com.groos.monitoring.agent.client.dto;

import java.util.List;

public class HeartbeatResult {
	
	private List<CommandRequest> commandRequestList;

	public List<CommandRequest> getCommandRequestList() {
		return commandRequestList;
	}

	public void setCommandRequestList(List<CommandRequest> commandRequestList) {
		this.commandRequestList = commandRequestList;
	} 
}
