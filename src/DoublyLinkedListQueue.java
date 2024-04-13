/**
 * @author DINESH KUMAR
 */

public class DoublyLinkedListQueue {

    static class ListNode{
        Node data;
        ListNode prev;
        ListNode next;

        ListNode(Node node){
            data = node;
            prev = null;
            next = null;
        }
    }
    ListNode head;
    ListNode tail;
    int size;

    DoublyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void add(Node node1) {
        ListNode node = new ListNode(node1);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    public Node pop() {
        if (head == null) {
            return null;
        } else {
            ListNode temp = head;
            if(head == tail){
                head = null;
                tail = null;
                return temp.data;
            }
            head = head.next;
            size--;
            return temp.data;
        }
    }

    public boolean isEmpty(){
        return size > 0;
    }
}
