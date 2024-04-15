import Helpers.*;

/**
 * @author DINESH KUMAR
 */

public class SuperPriorityQueue extends Heap {


    SuperPriorityQueue(String str){
        super(str);
    }

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


    public Entry insert(int key, int val){
        Entry entry = new Entry(key, val);

        insert(entry);

        return entry;
    }

    public Entry top(){
        return root.data;
    }

    public String state(){
        return (isMinHeap? "Min Heap" : "Max Heap");
    }

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){
        return size;
    }

    public int replaceKey(Entry entry, int key){
        int res = replaceKeyfromHeap(entry, key);
        heapifyDownFromRoot();
        return res;
    }
    public int replaceVal(Entry entry, int key){
        return replaceValfromHeap(entry, key);
    }

    public Entry removeTop(){
        return removeNode(root.data);
    }

    public Entry remove(Entry entry){
        return removeNode(entry);
    }
}
