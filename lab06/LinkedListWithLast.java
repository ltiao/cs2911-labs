package lab06;

import java.util.Iterator;

/** 
 * Linked list implementation.
 * Add method adds to end of list.
 * Implements last link as a data field.
 * 
 * @author John Potter
 *
 */

public class LinkedListWithLast implements List {
	
	private int size;
	private Link first;
	private Link last;
	
	public void add(Object o) {
		if (size == 0)
			first = last = new Link(o, null);
		else
			last = new Link(last, o);
		++size;
	}

	public boolean find(Object o) {
		for (Link current = first; current != null; current = current.getNext())
			if (current.getItem().equals(o))
					return true;
		return false;
	}

	public void print() {
		Link current = first;
		for (int i = 0; i < size; ++i) {
			System.out.println("" + i + ":" + current.getItem());
			current = current.getNext();
		}
	}

	public int size() {
		return size;
	}

	public Object getLast() {
		if (size == 0) throw new IllegalStateException("empty list");
		assert size > 0 : "list must be non-empty";
		return lastLink().getItem();
	}

	private Link lastLink() {
		return last;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}


}
