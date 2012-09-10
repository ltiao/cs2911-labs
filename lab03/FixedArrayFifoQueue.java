package lab03;

public class FixedArrayFifoQueue extends AbstractQueue implements FifoQueue
{
    private final Object [] data = new Object [capacity];
    private int size = 0;
    private int indexForAdd = 0;
    private int indexForRemove = 0;
    
    protected boolean invariant ()
    {
        // capacity == data.length is known
        return inIndexRange (indexForAdd) && inIndexRange (indexForRemove)
               && (indexForAdd >= indexForRemove && size == indexForAdd - indexForRemove
                   || indexForAdd <= indexForRemove && size == data.length - indexForAdd + indexForRemove);
    }

    private boolean inIndexRange (int index)
    {
        return 0 <= index && index < data.length;
    }
    
    public FixedArrayFifoQueue (int capacity)
    {
    	super (capacity);
    }

	@Override
	public int size() {
		return size;
	}

	@Override
	protected void unsafeAdd(Object x) {
		data[indexForAdd++] = x;
		size++;
	}

	@Override
	protected Object unsafeGet() {
		return data[indexForRemove];
	}

	@Override
	protected Object unsafeRemove() {
		Object temp = data[indexForRemove];
		data[indexForRemove] = null; // I supposed setting it to null is a sensible way to delete?
		indexForRemove++;
		size--;
		return temp;
	}
    
}