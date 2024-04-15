package Helpers;

/**
 * @author DINESH KUMAR
 * Heap is a helper class to implement Heap
 * It extends Tree class
 *
 */
 public class Heap extends Tree {

     protected static final String MINHEAP = "minheap";
     protected static final String MAXHEAP = "maxheap";
    protected boolean isMinHeap;


    /**
     * Constructor to initialize Heap
     * @param heap Type of Heap
     */
    public Heap(String heap){
        super();
        isMinHeap = heap.equalsIgnoreCase(MINHEAP);
    }


    /**
     * Insert a node to the Heap
     * @param data Entry to be added to the Heap
     */
    public void insert(Entry data){
        Node node = insertToTree(data);
        if(node != null){
            heapify(node);
        }
    }

    /**
     * Print the Heap in BFS order
     */
    public void printBFS() {
        if (root == null) return;

        DoublyLinkedListQueue queue = new DoublyLinkedListQueue();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size;

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.pop();
                System.out.print("(" + current.data.key +" , " + current.data.val + ") ");

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            System.out.println();
        }
    }

    /**
     * return boolean value based on the type of Heap
     * @param node Node to be compared
     * @param parent Parent Node
     * @return boolean value based on the type of Heap
     */
    private boolean isTrue(Node node, Node parent){
        if(!isMinHeap){
            return node.data.key > parent.data.key;
        } else{
            return node.data.key < parent.data.key;
        }
    }

    /**
     * Heapify the Heap
     * @param node Node to be heapified
     */
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

    /**
     * Heapify the Heap from the root
     */
    public void heapifyDownFromRoot() {
        heapifyDownFrom(root);
    }

    /**
     * Heapify the Heap from the given Node
     * @param root Node to be heapified
     */
    private void heapifyDownFrom(Node root) {
        Node current = root;

        while (current != null) {
            Node smallest = current;
            if (current.left != null && isTrue(current.left, smallest))
                smallest = current.left;
            if (current.right != null && isTrue(current.right, smallest))
                smallest = current.right;

            if (smallest.data.key == current.data.key)
                break;

            Entry temp = current.data;
            current.data = smallest.data;
            smallest.data = temp;

            current = smallest;
        }
    }

//    public Entry pop(){
//        Node node = root;
//        Node target = null;
//
//        DoublyLinkedListQueue list = new DoublyLinkedListQueue();
//        list.add(node);
//        while (!list.isEmpty()) {
//            Node current = list.pop();
//
//            if (current.left != null || current.right != null) {
//                if(current.left != null )
//                    list.add(current.left);
//                if(current.right != null)
//                    list.add(current.right);
//            }else if(list.isEmpty()){
//                target = current;
//            }
//        }
//        Entry temp = node.data;
//        node.data = target.data;
//        target.data = temp;
//        Node targetParent = getParent(target);
//        if(targetParent.right != null){
//            targetParent.right = null;
//        }else {
//            targetParent.left = null;
//        }
//        return delete(node.data);
//    }

    /**
     * Find the last Node in the Heap
     * @return Last Node in the Heap
     */
    private Node findLastNode(){
        if (root == null) return null;

        DoublyLinkedListQueue list = new DoublyLinkedListQueue();
        list.add(root);

        while (!list.isEmpty()) {
            Node current = list.pop();

            if(list.isEmpty() && current.left == null && current.right == null){
                return current;
            }

            if (current.left != null) {
                list.add(current.left);
            } if (current.right != null) {
                list.add(current.right);
            }
        }
        return root.left;

    }

    /**
     * remove a node from the Heap
     * @param entry Entry to be removed
     * @return Entry removed from the Heap
     */
    public Entry removeNode(Entry entry){
        Node src = findLastNode();

        Node target = find(entry);
        if(target!=null) {
            if (isMinHeap) {
                target.data.key = Integer.MIN_VALUE;
            } else {
                target.data.key = Integer.MAX_VALUE;
            }
            heapify(target);

            root.data = src.data;

            heapifyDownFromRoot();

            Node parent = getParent(src);
            if (parent != null) {
                if (parent.right != null && equals(src.data, parent.right.data)) {
                    parent.right = null;
                } else if (equals(src.data, parent.left.data)) {
                    parent.left = null;
                }
            }
        } else {
            System.out.println("Entry does not exist in the heap");
        }



        return entry;
    }

    /**
     * Replace the key of the Entry in the Heap
     * @param entry Entry to be replaced
     * @param key Key to be replaced
     * @return old Key in the Heap
     */
    protected int replaceKeyfromHeap(Entry entry, int key){
        Node node = find(entry);
        if(node != null){
            if(isMinHeap){
                node.data.key = Integer.MIN_VALUE;
            }else{
                node.data.key = Integer.MAX_VALUE;
            }
            heapify(node);
            int temp = node.data.key;
            root.data.key = key;
            heapifyDownFromRoot();
            return entry.key;
        }
        return 0;
    }

    /**
     * Replace the value of the Entry in the Heap
     * @param entry Entry to be replaced
     * @param val Value to be replaced
     * @return old Value in the Heap
     */
    protected int replaceValfromHeap(Entry entry, int val){
        Node node = find(entry);
        if(node != null){
            int temp = node.data.val;
            node.data.val = val;
            return temp;
        }
        return 0;
    }

}
