package lab03;

import java.util.LinkedList;

public class LinkedListFifoQueue extends AbstractQueue implements FifoQueue
{
    private LinkedList <Object> elements = new LinkedList <Object> ();

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	protected void unsafeAdd(Object x) {
		elements.addLast(x);
	}

	@Override
	protected Object unsafeGet() {
		return elements.getFirst();
	}

	@Override
	protected Object unsafeRemove() {
		return elements.remove();
	}
    
}