
package queuemanager;

/**
 *
 * @author lukas
 */
public class UnsortedArrayPriorityQueue<T> implements PriorityQueue<T>{
    
    /** 
     * I also will make use of the Core Object class and cast the 
     * Object later to the PriorityItem<T> when needed  
     */
    //The Array object where we save our items
    private Object[] storage;
    
    // size of the storage array
    private int capacity;
    
    // index of last item stored
    private int tailIndex;
    
    //Constructor for Priorityqueue class
    public UnsortedArrayPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }
    
    @Override
    // finds the item on top of the queue
    public T head() throws QueueUnderflowException {
        // checks of array is empty
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        //temp variable to compare to
        PriorityItem<T> highestPriorityItem = (PriorityItem<T>) storage[0];
        //looping through array
        for (int i = 0; i < tailIndex; i++) {
            //comparing item being iterrated against stored temp item to find highest priority
            PriorityItem<T> current = (PriorityItem<T>) storage[i];
            //if item in array higher then temporary stored, gets replaced
            if (current.getPriority() > highestPriorityItem.getPriority()) {
                highestPriorityItem = current;                
            }
        }
        return highestPriorityItem.getItem();
    }

    @Override
    // adds an item to the array
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex + 1 >= capacity) {
            //resizing if array is full
            System.out.println("Storage full, resizing");
            resize();
        }
        //incrementing the tailIndex for the added Priorityitem
        storage[++tailIndex] = new PriorityItem<>(item, priority);
    }

    @Override
    //removing item with highest priority from the array
    public void remove() throws QueueUnderflowException {
        int removeIndex = 0;
        //check if array is empty
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }else {
            //initialising a temporary variable
            int highestPriority = ((PriorityItem<T>)storage[0]).getPriority();
            //looping through the array to find highest priority item
            for (int i = 0; i < tailIndex; i++) {
                if (((PriorityItem<T>)storage[i]).getPriority() > highestPriority){
                    removeIndex = i;
                }
            }
            /*replacing the removed item with the item at the last index and 
            * decrementing tailIndex
            */
            storage[removeIndex] = storage[tailIndex];
            tailIndex--;
            
        }
    }

    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }
    
    // function for resizing or doubleing the array
    private void resize() {
        //local variable takes current arraysize and doubles it
        int newSize = capacity * 2;
        //new container where we will copy the items from "old" container to
        Object[] newStorage = new Object[newSize];
        System.arraycopy(storage, 0, newStorage, 0, storage.length);
        storage = newStorage;
        capacity = newSize;
    }
    
    
    // same as in ordered Array
    @Override
    //method to display the array
    public String toString() {
        // temp varibale to append items in array to
        String result = "[";
        // looping through the array and adding items to temp variable
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            //adding item to the existing array
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
    
}
