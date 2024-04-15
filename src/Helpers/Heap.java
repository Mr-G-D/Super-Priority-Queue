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
        isMinHeap = heap.equalsIgnoreCase(MINHEAP);
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
        if(!isMinHeap){
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
    public void heapifyDownFromRoot() {
        heapifyDownFrom(root);
    }

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
    public Entry removeNode(Entry entry){
        Node src = findLastNode();

        Node target = find(entry);
        if(isMinHeap){
            target.data.key = Integer.MIN_VALUE;
        }else{
            target.data.key = Integer.MAX_VALUE;
        }
        heapify(target);

        root.data = src.data;

        heapifyDownFromRoot();

        Node parent = getParent(src);
        if(parent != null){
            if(parent.right != null && equals(src.data, parent.right.data)){
                parent.right = null;
            }else if(equals(src.data, parent.left.data)){
                parent.left = null;
            }
        }



        return entry;
    }

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
