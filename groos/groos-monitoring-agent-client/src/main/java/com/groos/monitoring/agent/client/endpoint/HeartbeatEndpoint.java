package com.groos.monitoring.agent.client.endpoint;

import com.groos.monitoring.agent.client.dto.Heartbeat;
import com.groos.monitoring.agent.client.dto.HeartbeatResult;

public interface HeartbeatEndpoint {

	HeartbeatResult sendHeartbeat(Heartbeat heartbeat) throws ServerSideException, ClientSideException;

}
