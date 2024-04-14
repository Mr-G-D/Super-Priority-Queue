package Helpers;

/**
 * @author DINESH KUMAR
 */


public class Node {


    public Entry data;
    public Node left;
    public Node right;


    Node(Entry data) {
        this.data = data;
        left = null;
        right = null;
    }
}
