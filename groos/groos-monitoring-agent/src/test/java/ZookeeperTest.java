import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.ZooKeeper.States;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ZookeeperTest {
	
	private ZooKeeper zooKeeper; 
	
	@Before public void setUp() throws IOException { 
		zooKeeper = new ZooKeeper("192.168.0.7:2181", 3000, null);
	}
	
	
	@After public void tearDown() {
		
	}
	
	@Test public void shouldConnected() throws IOException, KeeperException, InterruptedException {  
		States states = zooKeeper.getState();
		
		states.isAlive();
		
	}

}
