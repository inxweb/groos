package com.groos.monitoring.agent.cmdexec;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.groos.monitoring.agent.cmd.ProcessExecutor;

public class ProcessExecutorTest {

	@Test
	public void test() throws Exception {
		ProcessExecutor processExecutor = new ProcessExecutor()
		.directory(new File("c:\\"))
		.command("cmd")
		.command("/c")
		.command(" ")
		.command("-c")
		.execute(); 
		
		System.out.println("상태 : " + processExecutor.getStatus());
		System.out.println("정상메시지 :" + processExecutor.getStdout());
		System.out.println("에러메시지 : " + processExecutor.getStderr());
 	}

}
