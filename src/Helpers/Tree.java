package Helpers;

import Helpers.DoublyLinkedListQueue;

/**
 * @author DINESH KUMAR
 */
public class Tree {


    protected Node root;

    Tree() {
        root = null;
    }

    protected void setTree(Node node){
        root = node;
    }

    void insertRec(int data) {
        root = insertRec(root, data);
    }


    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public Node insertToTree(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        DoublyLinkedListQueue list = new DoublyLinkedListQueue();
        list.add(root);

        while (!list.isEmpty()) {
            Node current = list.pop();

            if (current.left == null) {
                current.left = new Node(value);
                return current.left;
            } else if (current.right == null) {
                current.right = new Node(value);
                return current.right;
            } else {
                // Both children are not null, so add them to the list for further exploration
                list.add(current.left);
                list.add(current.right);
            }
        }

        return null;
    }

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

    public void printTreein2D() {
        printTreein2D(root, 0);
    }

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
        System.out.print(root.data + "\n");

        printTreein2D(root.left, space);
    }




}