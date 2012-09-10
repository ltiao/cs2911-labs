package lab03;

import org.junit.Before;

public class LinkedListFifoQueueTest extends QueueTest {
	
	@Override @Before
	public void setUp() throws Exception {
		queue = new LinkedListFifoQueue();
	}

}