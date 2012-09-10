package lab06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ListTest {

	protected List list;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList();
//		list = new LinkedList();
//		list = new LinkedListAtLast();
//		list = new LinkedListWithLast();
	}

	Object item1 = "aString";
	Object item2 = "anotherString";
	Object item3 = "yetAnotherString";
	

	@Test
	public void testSetUp() {
		assertNotNull(list);
	}

	@Test
	public void testInitSize() {
		assertEquals("Empty list", 0, list.size());
	}

	@Test
	public void testInitFind() {
		assertFalse("Empty list", list.find(item1));
	}

	@Test
	public void testInitPrint() {
		list.print();
	}

	@Test
	public void testAddSize() {
		list.add(item1);
		assertEquals("One item added", 1, list.size());
	}

	@Test
	public void testAddFind() {
		list.add(item1);
		assertTrue("One item added", list.find("aString"));
		assertFalse("One item added", list.find(item2));
	}

	@Test
	public void testAddPrint() {
		System.out.println();
		System.out.println("Output for testAddPrint ... ");
		list.add(item1);
		list.print();
	}

	@Test
	public void testMultipleAddSize() {
		multipleAdd();
		assertEquals("Many items added", 1025, list.size());
	}

	@Test
	public void testMultipleAddFind() {
		multipleAdd();
		assertTrue("Many items added", list.find(item1));
		assertTrue("Many items added", list.find(item2));
		assertFalse("Many items added", list.find(item3));
	}

	@Test
	public void testMultipleAddPrint() {
		System.out.println();
		System.out.println("Output for testMultipleAddPrint ... ");
		multipleAdd();
		list.print();
	}

	void multipleAdd() {
		for (int i = 0; i < 1024; ++i) list.add(item1);
		list.add(item2);
	}

	@Test
	public void testAddLast() {
		list.add(item1);
		assertEquals("The one item added, is last item", item1, list.getLast());
	}

	@Test
	public void testMultipleAddLast() {
		multipleAdd();
		assertEquals("Many items added, last added is last item", item2, list.getLast());
	}
	
	@Test(expected = Throwable.class)
	public void testGetLast() {
		assertEquals("GetLast precondition violated", null, list.getLast());
	}
}