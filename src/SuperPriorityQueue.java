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

//    public Entry removeTop(){
//        return pop();
//    }

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
    public void heapifyDownFromRoot() {
        heapifyDownFrom(root);
    }

    private void heapifyDownFrom(Node root) {
        Node current = root;

        while (current != null) {
            Node smallest = current;
            if (current.left != null && current.left.data.key < smallest.data.key)
                smallest = current.left;
            if (current.right != null && current.right.data.key < smallest.data.key)
                smallest = current.right;

            if (smallest.data.key == current.data.key)
                break;

            Entry temp = current.data;
            current.data = smallest.data;
            smallest.data = temp;

            current = smallest;
        }
    }

    public void replace(Entry entry, int key){
        replaceKey(entry, key);
        heapifyDownFromRoot();
    }
}
