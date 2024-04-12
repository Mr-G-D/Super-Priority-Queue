import java.util.LinkedList;

/**
 * @author DINESH KUMAR
 */
 class Heap extends Tree{

     static final String MINHEAP = "minheap";
     static final String MAXHEAP = "maxheap";
    boolean isMinHeap;


    Heap(String heap){
        super();
        isMinHeap = !heap.equalsIgnoreCase(MINHEAP);
    }

    public void insert(int data){
        Node node = inserttoTree(data);
        if(node != null){
            heapify(node);
        }
    }

    public void printBFS() {
        if (root == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
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
            return node.data > parent.data;
        } else{
            return node.data < parent.data;
        }
    }

    private void heapify(Node node) {
        Node parent = getParent(node);
        while (parent != null && isTrue(node, parent)) {
            int temp = node.data;
            node.data = parent.data;
            parent.data = temp;

            node = parent;
            parent = getParent(node);
        }
    }



}
