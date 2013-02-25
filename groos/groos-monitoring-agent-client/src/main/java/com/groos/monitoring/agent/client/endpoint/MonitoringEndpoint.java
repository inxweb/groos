package com.groos.monitoring.agent.client.endpoint;

import com.groos.monitoring.agent.client.dto.Monitoring;
import com.groos.monitoring.agent.client.dto.MonitoringResult;

public interface MonitoringEndpoint {

	MonitoringResult sendMessagee(Monitoring monitoring);

}
