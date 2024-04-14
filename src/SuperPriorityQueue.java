import Helpers.DoublyLinkedListQueue;
import Helpers.Heap;
import Helpers.Node;

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
}
