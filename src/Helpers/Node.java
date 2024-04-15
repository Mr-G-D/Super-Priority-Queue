package Helpers;

/**
 * Assignment 3
 * COMP 6481
 * Written by: Dinesh Kumar Gopinathan (40273281) Sanjay Bharathi Subramanian (40248572)
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
