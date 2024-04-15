import Helpers.*;

/**
 * @author DINESH KUMAR
 * SuperPriorityQueue is a class to implement Priority Queue using Heap
 */

public class SuperPriorityQueue extends Heap {


    /**
     * Constructor to initialize SuperPriorityQueue
     */
    SuperPriorityQueue(String str){
        super(str);
    }

    /**
     * change the state of the Heap
     * MinHeap to MaxHeap and vice versa
     */
    public void toggle(){

        Node node = root;

        root = null;
        isMinHeap = !isMinHeap;

        DoublyLinkedListQueue queue = new DoublyLinkedListQueue();
        queue.add(node);

        while (!queue.isEmpty()){
            Node curr = queue.pop();
            insert(curr.data);
            if(curr.left != null){
                queue.add(curr.left);
            }if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }


    /**
     * Insert a node to the Heap
     * @param key Key of the Entry to be added to the Heap
     * @param val Value of the Entry to be added to the Heap
     * @return Entry added to the Heap
     */
    public Entry insert(int key, int val){
        Entry entry = new Entry(key, val);

        insert(entry);

        return entry;
    }

    /**
     * return the top node of the Queue
     * @return Entry at the top of the Queue
     */
    public Entry top(){
        return root.data;
    }

    /**
     * return the state of the Heap
     * @return state of the Heap
     */
    public String state(){
        return (isMinHeap? "Min Heap" : "Max Heap");
    }

    /**
     * return if the Queue is empty or not
     * @return boolean value based on the size of the Queue
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * return the size of the Queue
     * @return size of the Queue
     */
    public int size(){
        return size;
    }

    /**
     * replace the key of the Entry
     * @param entry Entry whose key is to be replaced
     * @param key Key to be replaced
     * @return old Key
     */
    public int replaceKey(Entry entry, int key){
        int res = replaceKeyfromHeap(entry, key);
        heapifyDownFromRoot();
        return res;
    }

    /**
     * replace the value of the Entry
     * @param entry Entry whose value is to be replaced
     * @param key Value to be replaced
     * @return old Value
     */
    public int replaceVal(Entry entry, int key){
        return replaceValfromHeap(entry, key);
    }

    /**
     * remove the top node of the Queue
     * @return Entry removed from top of the Queue
     */
    public Entry removeTop(){
        return removeNode(root.data);
    }

    /**
     * remove a node from the Queue
     * @param entry Entry to be removed
     * @return Entry removed from the Queue
     */
    public Entry remove(Entry entry){
        return removeNode(entry);
    }
}
