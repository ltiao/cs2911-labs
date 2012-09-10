package lab06;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class LinkedListAtLastIteratorTest {

	List testList = new LinkedListAtLast();
	Iterator<Object> it;
	
	List testList2 = new LinkedListAtLast();
	Iterator<Object> it2;
	
	@Before
	public void setUp() throws Exception {
		testList.add("a");
		testList.add("b");
		testList.add("c");
		testList.add("Foo");
		testList.add("Bar");
		testList.add("Baz");
		it = testList.iterator();
		
		testList2.add("a");
		testList2.add("b");
		testList2.add("c");
		testList2.add("Foo");
		testList2.add("Bar");
		testList2.add("Baz");
		it2 = testList2.iterator();
	}
	
	@Test
	public void testHasNext()	 {
		assertTrue ("testList does have next", it.hasNext());
	}
	
	@Test
	public void testNotHasNext()	 {
		while (it.hasNext())
			it.next();
		assertFalse ("testList does not have next", it.hasNext());
	}
	
	@Test
	public void testEqualsReflexive()	 {
		assertTrue ("testList equals itself", testList.equals(testList));
	}
	
	@Test
	public void testEqualsSymmetric()	 {
		assertTrue ("testList equals testList2", testList.equals(testList2));
		assertTrue ("testList2 equals testList", testList2.equals(testList));
	}
	
	@Test
	public void testEqualsTransitive()	 {
		// TODO
	}
	
	@Test
	public void testEqualsListOfLists()	 {
		// TODO
	}
	
	@Test
	public void testHashCodeListOfLists()	 {
		// TODO
	}
	
	@Test
	public void testInequality() {
		testList2.add("random");
		assertFalse ("the lists are no longer equal", testList.equals(testList2));
	}
	
	@Test
	public void testHashCode() {
		assertEquals ("testList.equals(testList1) implies equality of hashCodes", testList.hashCode(), testList2.hashCode());
	}
	
	@Test
	public void testHashCodeInequality() {
		testList2.add("random");
		assertFalse ("testList.equals(testList1) implies equality of hashCodes", testList.hashCode() == testList2.hashCode());
	}
	
	@Test
	public void testToString()	 {
		System.out.println("ToString:");
		System.out.println(testList);
	}
	
	@Test
	public void testOldIteration() {
		Iterator<Object> it = testList.iterator();
		System.out.println("Traditional iteration with explicit iterator:");
		while (it.hasNext())
			System.out.println(it.next());
	}
	
	@Test
	public void testCoolJava5Iteration() {
		System.out.println("Implicit iterators from Java 5+:");
		for (Object e : testList)
			System.out.println(e);
	}

}
