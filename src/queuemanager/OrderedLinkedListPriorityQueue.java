
package queuemanager;

/**
 *@author lukas 
 */
public class OrderedLinkedListPriorityQueue<T> implements PriorityQueue<T>  {
   
    //Attributes of the OrderedLinkedListPriorityQueue 
    //Stores the PriorityItem and the pointer to its next node
    private ListNode<T> top;
    //keeps track of the size of the list
    private ListNode<T> tail;
    
    //Constructor
    public OrderedLinkedListPriorityQueue() {
        //When initialized the list is empty and top will be null and also not pointing to any node.
        top = null;
        tail = null;
        
        
    }
    
    /*  Mehtod to add a Person to the List
    * 
    */
    @Override
    public void add(T item, int priority) throws QueueOverflowException {
        //instanciating the new item and the new Node
        PriorityItem<T> new_item = new PriorityItem(item, priority);
        ListNode<T> new_Node = new ListNode(new_item, null);
        
        // checking if the new item is at the head of the queue
        if(top == null || new_Node.getItemPriority() > top.getItemPriority()) {
            new_Node.setNext(top);
            top = new_Node;
            if(top.getNext() == null) {
                tail = top; //Updating tail if this is the first node being added
            }
        }else {
            ListNode<T> current = top;
            // checking where to insert new item into the queue depending on priority
            while (current.getNext() != null && current.getNext().getItemPriority() <= new_Node.getItemPriority()) {
            current = current.getNext();
            }
            // inserting the new item at the position and changing where the new and old pointers are pointing to.
            new_Node.setNext(current.getNext());
            current.setNext(new_Node);
            
            if (new_Node.getNext() == null) {
                tail = new_Node;
            }
        }
    }
       
        
        
        
    
    /* because the list is ordered this fiunction is very easy 
    *  if the list is not empty, the first item in the list will always be 
    *  the one with the highest priority
    */
    @Override
    public T head() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        return top.getListItem();
        
    }

    @Override
    public void remove() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        top = top.getNext();
    }

    
    // boolean method to check if the list is empty 
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
            result += current.getListItem().toString();
            current = current.getNext();
        }
        result += "]";
        return result;
        
    }

}
