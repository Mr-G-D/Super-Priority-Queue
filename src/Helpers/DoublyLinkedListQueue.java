package Helpers;

/**
 * Assignment 3
 * COMP 6481
 * Written by: Dinesh Kumar Gopinathan (40273281) Sanjay Bharathi Subramanian (40248572)
 * DoublyLinkedListQueue is a helper class to implement Queue using Doubly Linked List
 */
public class DoublyLinkedListQueue {

    /**
     * ListNode is a helper class to implement Doubly Linked List
     */
    static class ListNode{
        Node data;
        ListNode prev;
        ListNode next;

        /**
         * Constructor to initialize ListNode
         * @param node Node to be added to the list
         */
        ListNode(Node node){
            data = node;
            prev = null;
            next = null;
        }
    }
    ListNode head;
    ListNode tail;
    int size;

    /**
     * Constructor to initialize DoublyLinkedListQueue
     */
    public DoublyLinkedListQueue() {
        head = null;
        tail = null;
    }

    /**
     * Add a node to the queue
     * @param node1 Node to be added to the queue
     */
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

    /**
     * Remove a node from the queue
     * @return Node removed from the queue
     */
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

    /**
     * Check if the queue is empty
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty(){
        return size <= 0;
    }
}
