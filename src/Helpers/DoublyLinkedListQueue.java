package Helpers;

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

    public DoublyLinkedListQueue() {
        head = null;
        tail = null;
    }

    public void add(Node node1) {
        ListNode node = new ListNode(node1);
        if (head == null && tail == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            node.prev = tail;
            head.prev = null;
            tail = node;
        }
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
                size--;
                return temp.data;
            }
            head = head.next;
            size--;
            return temp.data;
        }
    }

    public boolean isEmpty(){
        return size <= 0;
    }
}
