import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DFSClient;
import org.apache.hadoop.hdfs.protocol.HdfsFileStatus;
import org.junit.Before;
import org.junit.Test;


public class DfsClientTest {
	private DFSClient dfsClient = null; 
	@Before public void setUp() throws IOException {
		InetSocketAddress address = new InetSocketAddress("192.168.0.7", 9000);
		
		Configuration config = new Configuration();  
		
		this.dfsClient = new DFSClient(address, config);
	}
	
	@Test public void testing() { 
	 
		OutputStream os = null;
		
		PrintWriter pw = null;
		
		try { 
			
			os = dfsClient.create("/temp/" + String.valueOf(System.currentTimeMillis()), true);
			
			pw = new PrintWriter(os);
			
			pw.println("zzzzzzzzzz-yyyyyyyyyyyyyyy");
			
			pw.flush(); 
			
		} catch (IOException e) { 
			e.printStackTrace();
		} finally { 
			IOUtils.closeQuietly(os);
			IOUtils.closeQuietly(pw);
		} 
		
		//when
		
		//then
	}
	
	@Test public void testing2() { 
		 
		OutputStream os = null;
		
		PrintWriter pw = null;
		
		try { 
			
			HdfsFileStatus hdfsFileStatus = dfsClient.getFileInfo("/");
			 
			
			pw = new PrintWriter(os);
			
			pw.println("zzzzzzzzzz-yyyyyyyyyyyyyyy");
			
			pw.flush(); 
			
		} catch (IOException e) { 
			e.printStackTrace();
		} finally { 
			IOUtils.closeQuietly(os);
			IOUtils.closeQuietly(pw);
		} 
		
		//when
		
		//then
	}

}
