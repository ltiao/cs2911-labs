package lab03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public abstract class QueueTest {

	protected Queue queue;

	@Before
	public abstract void setUp() throws Exception;
	
	Object	item1	= "apple";
	Object	item2	= "orange";
	Object	item3	= "banana";

	@Test
	public void testSetUp ()
	{
		assertNotNull (queue);
	}
	
	@Test
	public void testAdd() {
		queue.add(item1);
		assertEquals ("last item added was item1", item1, queue.get ());
	}

	@Test
	public void testGet() {
		queue.add(item2);
		assertEquals ("last item is item2", item2, queue.get ());
	}

	@Test
	public void testRemove() {
		queue.add(item1);
		queue.add(item2);
		assertEquals ("remove last item which is item1", item1, queue.remove ());
		assertEquals ("queue now only has item2", item2, queue.get ());
		assertEquals ("so queue only has one item", 1, queue.size ());
	}

	@Test
	public void testSize() {
		queue.add(item1);
		queue.add(item2);
		assertEquals ("queue has 2 items", 2, queue.size ());
	}

	@Test
	public void testIsEmpty() {
		assertTrue ("Queue is empty", queue.isEmpty());
		queue.add (item1);
		assertFalse ("Queue is no longer empty", queue.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse ("Queue is not yet full", queue.isFull());
		/*for (int i = 0 ; i < Integer.MAX_VALUE ; i++) {
			queue.add(item1);
		}
		assertTrue ("Queue is now full", queue.isFull());
		*/
	}
	
	@Test
	public void testInitSize ()
	{
		assertEquals ("Empty queue", 0, queue.size ());
	}
	
	@Test
	public void testAddSize() {
		queue.add(item1);
		assertEquals ("One item added", 1, queue.size ());
	}

}
