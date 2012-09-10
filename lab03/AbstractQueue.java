package lab03;

/** Abstract implementation of Queue interface.
 * Provides default implementations of operations, enforcing preconditions.
 * Relies on abstract size and update operations which must be implemented by subclasses.
 */
public abstract class AbstractQueue implements Queue
{
    /** General technique for enforcing a precondition.
     * Throws an exception if precondition is false.
     * @param b precondition to be enforced
     * @param desc message for exception
     */
    public static void require (boolean b, String desc)
    {
        if (!b)
            throw new IllegalStateException ("require" + desc);
    }
    
    public final int capacity;
    
    protected AbstractQueue ()
    {
        this.capacity = Integer.MAX_VALUE;
    }
    
    protected AbstractQueue (int capacity)
    {
        this.capacity = capacity;
    }
    
    public void add (Object x)
    {
        require (!isFull (), "is not full");
        unsafeAdd (x);
    }
    
    public Object get ()
    {
        require (!isEmpty (), "is not empty");
        return unsafeGet ();
    }
    
    public boolean isEmpty ()
    {
        return size () == 0;
    }
    
    public boolean isFull ()
    {
        return size () == capacity;
    }
    
    public Object remove ()
    {
        require (!isEmpty (), "is not empty");
        return unsafeRemove ();
    }
    
    public abstract int size ();
    
    protected abstract void unsafeAdd (Object x);
    
    protected abstract Object unsafeGet ();
    
    protected abstract Object unsafeRemove ();
    
}
