package lab03;

import org.junit.Before;

public class FixedArrayFifoQueueTest extends QueueTest{
	
	@Override @Before
	public void setUp() throws Exception {
		queue = new FixedArrayFifoQueue(20);
	}

}