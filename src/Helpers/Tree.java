package Helpers;

import Helpers.DoublyLinkedListQueue;

/**
 * @author DINESH KUMAR
 * Tree is a helper class to implement Tree
 */
public class Tree {


    protected Node root;
    protected int size;

    /**
     * Constructor to initialize Tree
     */
    public Tree() {
        root = null; size = 0;
    }


    /**
     * Insert a node to the Tree
     * @param value Entry to be added to the Tree
     * @return Node added to the Tree
     */
    public Node insertToTree(Entry value) {
        if (root == null) {
            size++;
            root = new Node(value);
            return root;
        }

        DoublyLinkedListQueue list = new DoublyLinkedListQueue();
        list.add(root);

        while (!list.isEmpty()) {
            Node current = list.pop();

            if (current.left == null) {
                size++;
                current.left = new Node(value);
                return current.left;
            } else if (current.right == null) {
                size++;
                current.right = new Node(value);
                return current.right;
            } else {
                list.add(current.left);
                list.add(current.right);
            }
        }

        return null;
    }

    /**
     * Get the parent of a Node
     * @param node Node whose parent is to be found
     * @return Parent of the Node
     */
    Node getParent(Node node) {
        if (node == null || node == root) {
            return null;
        }

        DoublyLinkedListQueue queue = new DoublyLinkedListQueue();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.pop();
            if (current.left == node || current.right == node) {
                return current;
            }
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return null;
    }

    /**
     * Print the Tree in 2D
     */
    public void printTreein2D() {
        printTreein2D(root, 0);
    }

    /**
     * Print the Tree in 2D
     * @param root Node to be printed
     * @param space Space to be added
     */
    void printTreein2D(Node root, int space) {
        if (root == null) {
            return;
        }

        space += 10;

        printTreein2D(root.right, space);

        System.out.println();
        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.data.key + "\n");

        printTreein2D(root.left, space);
    }

    /**
     * Swap two nodes
     * @param n1 Node 1
     * @param n2 Node 2
     */
    private void swap(Node n1, Node n2){
        Entry entry = n1.data;
        n1.data = n2.data;
        n2.data = entry;

    }


//    private Entry deleteRec(Node node, Entry entry){
//        if(node.data.key == entry.key){
//            Node curr = node;
//            while (curr != null){
//                if(curr.right != null){
//                    swap(curr, curr.right);
//                    curr = curr.right;
//                }else if(curr.left != null){
//                    swap(curr, curr.left);
//                    curr = curr.left;
//                }else{
//                    Node parent = getParent(curr);
//                    if(parent != null){
//                        if(parent.right != null){
//                            parent.right = null;
//                        }else {
//                            parent.left = null;
//                        }
//                    }
//
//                }
//            }
//            return node.data;
//        }else{
//            if(node.left != null) {
//                Entry temp =  deleteRec(node.left, entry);
//            }if (node.right != null){
//                return deleteRec(node.right, entry);
//            }
//        }
//    }

    /**
     * find the node in the tree
     * @param node Node to be searched
     * @param entry Entry to be searched
     * @return Node found in the tree
     */
    private Node findNode(Node node, Entry entry){
        if(node == null || equals(node.data, entry)){
            return node;
        }

        Node left = findNode(node.left, entry);
        if(left != null){
            return left;
        }

        Node right = findNode(node.right, entry);
        if(right != null){
            return right;
        }

        return null;

    }

    /**
     * Check if two entries are equal
     * @param e1 Entry 1
     * @param e2 Entry 2
     * @return true if equal, false otherwise
     */
    protected boolean equals(Entry e1, Entry e2){
        return (e1.key == e2.key && e1.val == e2.val);
    }

    /**
     * Find the node in the tree
     * @param entry Entry to be searched
     * @return Node found in the tree
     */
    protected Node find( Entry entry){
        return findNode(root, entry);
    }

}
