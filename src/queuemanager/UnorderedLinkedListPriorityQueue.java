
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
        return top.getListItem();
    }

    @Override
    public void remove() throws QueueUnderflowException {
        
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
            result += current.getListItem().toString();
            current = current.getNext();
        }
        result += "]";
        return result;
    }
    
    
}
