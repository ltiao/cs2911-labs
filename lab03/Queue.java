package lab03;

/** A queue is a linear data structure.
 * It provides operations to add and remove elements.
 * The queueing policy determines where add and removes occur.
 */
public interface Queue
{
    /** Add an element to the queue.
     * Requires queue is not full. See {@link #isFull()}
     * @param x element to add
     */
    void add (Object x);
    
    /** Access an element in the queue.
     * There is no change to the queue.
     * @return an element in the queue.
     */
    Object get ();
    
    /** Remove an element from the queue.
     * The element removed must be the same as that returned by {@link #get()}
     * @return the element removed from the queue
     */
    Object remove ();
    
    /** Number of elements in the queue.
     * Requires queue is not empty. See {@link #isEmpty()}
     * @return size of queue
     */
    int size ();
    
    /** Is queue empty?
     * True if and only if size () == 0
     * @return is queue empty?
     */
    boolean isEmpty ();
    
    /** Is queue full?
     * True if queue cannot be expanded with more elements.
     * @return is queue full?
     */
    boolean isFull ();
    
}
