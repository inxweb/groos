package com.groos.monitoring.agent.client.dto;

import java.util.List;

public class Heartbeat { 
	private List<CommandResult> commandResultList;

	public List<CommandResult> getCommandResultList() {
		return commandResultList;
	}

	public void setCommandResultList(List<CommandResult> commandResultList) {
		this.commandResultList = commandResultList;
	}
	
	
}
