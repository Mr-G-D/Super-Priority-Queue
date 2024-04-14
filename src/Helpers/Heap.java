package Helpers;

/**
 * @author DINESH KUMAR
 */
 public class Heap extends Tree {

     protected static final String MINHEAP = "minheap";
     protected static final String MAXHEAP = "maxheap";
    protected boolean isMinHeap;


    public Heap(String heap){
        super();
        isMinHeap = !heap.equalsIgnoreCase(MINHEAP);
    }


    public void insert(Entry data){
        Node node = insertToTree(data);
        if(node != null){
            heapify(node);
        }
    }

    public void printBFS() {
        if (root == null) return;

        DoublyLinkedListQueue queue = new DoublyLinkedListQueue();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.pop();
                System.out.print(current.data + " ");

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println();
        }
    }

    private boolean isTrue(Node node, Node parent){
        if(isMinHeap){
            return node.data.key > parent.data.key;
        } else{
            return node.data.key < parent.data.key;
        }
    }

    private void heapify(Node node) {
        Node parent = getParent(node);
        while (parent != null && isTrue(node, parent)) {
            Entry temp = node.data;
            node.data = parent.data;
            parent.data = temp;

            node = parent;
            parent = getParent(node);
        }
    }



}
