package lab06;

import java.util.Iterator;
import java.lang.StringBuilder;
/** 
 * Linked list implementation.
 * Add method adds to end of list.
 * 
 * @author John Potter
 *
 */
public class LinkedListAtLast implements List {
	
	private int size;
	private Link first;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// If objects are identical then we are done
		if ( this == obj ) return true;
		if ( !(obj instanceof LinkedListAtLast) ) return false;
		LinkedListAtLast that = (LinkedListAtLast) obj;
		if (this.size!=that.size) return false;
		boolean equals = true;
		Iterator<Object> thisIt = this.iterator();
		Iterator<Object> thatIt = that.iterator();
		while (thisIt.hasNext()&&thatIt.hasNext())
			equals &= thisIt.next().equals(thatIt.next());
		return equals;
	}

	@Override
	public int hashCode() {
		int hashCode = 1;
		// Linear hashing algorithm. Becomes quadratic when hashing a list of lists
		for (Object obj : this)
			hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
		return hashCode;
	}

	@Override
	public String toString() {
		StringBuilder sd = new StringBuilder();
		for (Object e: this)
			sd.append("["+e+"], ");
		return sd.toString();
	}

	public void add(Object o) {
		if (size == 0)
			first = new Link(o, null);
		else
			new Link(lastLink(), o);
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
		Link current = null;
		Link next =  first;
		while (next != null) {
			current = next;
			next = next.getNext();
		}
		return current;
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {
			Link current = first;
			
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public Object next() {
				Link temp = current;
				current = current.getNext();
				return temp.getItem(); 
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
