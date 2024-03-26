
package queuemanager;

/**
 *
 * @author lukas
 * @param <T> Placeholder for item to be inserted of any type
 */
public class UnorderedLinkedListPriorityQueue<T> implements PriorityQueue<T> {
    
        //Attributes of the OrderedLinkedListPriorityQueue 
    //Stores the PriorityItem and the pointer to its next node
    private ListNode<T> top;
    //end of the list
    private ListNode<T> tail;
    
    private int size;
    
    //Constructor
    public UnorderedLinkedListPriorityQueue() {
        //When initialized the list is empty and top will be null and also not pointing to any node.
        top = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        PriorityItem<T> new_item = new PriorityItem(item, priority);
        ListNode<T> new_Node = new ListNode(new_item, null);
        if(isEmpty()) {
            top = tail = new_Node;
        }else {
            tail.setNext(new_Node);
            tail = new_Node;
        }
        size++;
    }

    @Override
    public T head() throws QueueUnderflowException {
        //checks if List is  empty
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        // making the top of the array our current Node 
        ListNode<T> current = top;
        //Initialising the highest Priority item with the current Item and Priority
        PriorityItem<T> highestPriorityItem = new PriorityItem<>(current.getListItem(), current.getItemPriority());
        // while loop to iterate through list
        while (current != null) {
            //if currents node priority is higher then stored highest Priority
            // highest PriorityItem is updated
            if(current.getItemPriority() > highestPriorityItem.getPriority()){
                highestPriorityItem = new PriorityItem<>(current.getListItem(), current.getItemPriority());
            }
            // next node
            current = current.getNext();
        }
        // returning item with highest Priority
        return highestPriorityItem.getItem();
    }
        
    

    @Override
    public void remove() throws QueueUnderflowException {
        //checks if List is  empty
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        // 
        ListNode<T> current = top;
        ListNode<T> previous = null;  // keepos track of the node before the current one
        ListNode<T> toRemove = top;
        ListNode<T> toRemovePrevious = null; // keeps track of the node before the to be removed node
        
        int highestPriority = current.getItemPriority();
        // finding the node with the highest Priority
        while(current != null) {
            if(current.getItemPriority() > highestPriority) {
                highestPriority = current.getItemPriority(); // updating highest priority
                toRemove = current;
                toRemovePrevious = previous;
            }
            previous = current;
            current = current.getNext();
        }
        
        // removing the node
        if(toRemove == top) {
            top = top.getNext();
            if (top == null) {
                tail = null;
            }
        }else if(toRemovePrevious != null){
            toRemovePrevious.setNext(toRemove.getNext());
            if (toRemove == tail) {
                tail = toRemovePrevious;
            }
        }
        size --;
    }
    
    
    @Override
    public boolean isEmpty() {
        return top == null;
    }
    
    @Override
    public String toString() {
        String result = "[";
        ListNode<T> current = top;
        while (current != null) {
            if (!result.equals("[")) {
                result += ", ";
            }
            result += "(" + current.getListItem().toString() + ", ";
            result += current.getItemPriority() + ")";
            current = current.getNext();
        }
        result += "]";
        return result;
    }
    
    
}
