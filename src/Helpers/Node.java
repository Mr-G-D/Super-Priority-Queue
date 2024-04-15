package Helpers;

/**
 * @author DINESH KUMAR
 * Node is a helper class to implement Node of a Tree
 */


public class Node {


    public Entry data;
    public Node left;
    public Node right;

    /**
     * Constructor to initialize Node
     * @param data Entry to be added to the Node
     */
    Node(Entry data) {
        this.data = data;
        left = null;
        right = null;
    }
}
