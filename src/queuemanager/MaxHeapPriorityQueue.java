
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
    
    //Array calculations to get the right Index in a Heap Array
    
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
    
    // Routine to swap to nodes when the a child node is bigger then its parent 
    private void swap(int indexOne, int indexTwo) {
        Object temp = storage[indexOne];
        storage[indexOne] = storage[indexTwo];
        storage[indexTwo] = temp;
    }
    
    
    /*
    * To maintain a Heap property we need to be able to "bubble up" an Item if
    * its Priority is bigger then its parent. 
    * When we remove an Item,
    * we place the Item at last index at the root index and then use the "bubble up" approach 
    * for the Items in the array.
    */
    
    // Routines to either bubble up or down
    
    private void bubbleUp() {
        int index = tailIndex;
        while (hasParent(index) && getParent(index).getPriority()  < ((PriorityItem<T>)storage[index]).getPriority()){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    
    private void bubbleDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int biggerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index).getPriority() > getLeftChild(index).getPriority()) {
                biggerChildIndex = getRightChildIndex(index);
            }
            if (((PriorityItem<T>)storage[index]).getPriority() < ((PriorityItem<T>)storage[biggerChildIndex]).getPriority()) {
                swap(index, biggerChildIndex);
            }else {
                break;
            }
            index = biggerChildIndex;
        }
    }
    
    // Abstract Methods from the interface

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        if (tailIndex + 1 >= capacity) {
            //doubling the array in size
            System.out.println("Storage full, resizing");
            resize();
        }
        //incrementing the tailindex first and then entering the new Item at the end of the array
        // Using bubbleUp() to maintain heap structure
        storage[++tailIndex] = new PriorityItem<>(item, priority);
        bubbleUp();
    }

    @Override
    public T head() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        PriorityItem<T> head = (PriorityItem<T>)storage[0];
        return head.getItem();
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        storage[0] = storage[tailIndex]; // taking item at last index and putting it in the first index
        storage[tailIndex] = null; // deleting the last index
        tailIndex--; // adjusting the index to the right size
        bubbleDown(); //maintaining heap structure by checking if parent > child
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
    
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }

}
