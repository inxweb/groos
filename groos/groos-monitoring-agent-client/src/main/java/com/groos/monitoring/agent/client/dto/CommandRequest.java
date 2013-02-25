package com.groos.monitoring.agent.client.dto;

import java.util.List;

public class CommandRequest {
	
	private String directory;
	
	private List<String> commandList;

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public List<String> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<String> commandList) {
		this.commandList = commandList;
	}
	 

}
