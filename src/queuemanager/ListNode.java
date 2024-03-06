
package queuemanager;

/* Just a wrapper for the PriorityItem to sit in
*  and  a pointer to point to the next item in the list
*/

public class ListNode<T> {
    // stores the Item we want to save
    private final PriorityItem<T> item;
    // pointer to the next node
    private ListNode<T> next;
    
    /*Constructor
    * @param item to store priority and name
    * @next stores the pointer to the next node
    */
    public ListNode(PriorityItem<T> item, ListNode<T> next) {
        this.item = item;
        this.next = next;
    }
    
    //Getters
    
    public int getItemPriority() {
        return item.getPriority();
    }
    
    public T getListItem() {
        return item.getItem();
    }
    
    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
