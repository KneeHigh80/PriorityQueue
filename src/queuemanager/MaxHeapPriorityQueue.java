
package queuemanager;

/**
 *
 * @author lukas
 * This will be my attempt to implement a Priority Queue by using a 
 * max Heap. 
 */
public class MaxHeapPriorityQueue<T> implements PriorityQueue<T>{
    
    // Array object to save Heap entries
    private Object[] storage;
    //size of the array
    private int capacity;
    // the item at the root
    private int tailIndex;
    
    public MaxHeapPriorityQueue(int size) {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }
    
    //Getters to get child or parent nodes and / or their indexes
    private PriorityItem<T> getLeftChild(int index) {
        return (PriorityItem<T>) storage[getLeftChildIndex(index)];
    }
    
    private PriorityItem<T> getRightChild(int index) {
        return (PriorityItem<T>) storage[getRightChildIndex(index)];
    }
    
    private PriorityItem<T> getParent(int index) {
        return (PriorityItem<T>) storage[getParentIndex(index)];
    }
    
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    
    private int getParentIndex(int childIndex) {
        return (childIndex -1) / 2;
    }
    
    
    //Control Routines to check if Node has Child or Parent
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index)<= tailIndex;
    }
    
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index)<= tailIndex;
    }
    
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        PriorityItem<T> current = new PriorityItem<>(item, priority);
        if (tailIndex + 1 >= capacity) {
            //doubling the array in size
            System.out.println("Storage full, resizing");
            resize();
        }
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return null;
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
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
    
    // Routine to swap to nodes when the a child node is bigger then its parent 
    private void swap(int indexOne, int indexTwo) {
        Object temp = storage[indexOne];
        storage[indexOne] = storage[indexTwo];
        storage[indexTwo] = temp;
    }
    
    
    
    
    
}
