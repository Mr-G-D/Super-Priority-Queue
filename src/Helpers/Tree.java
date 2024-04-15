package Helpers;

import Helpers.DoublyLinkedListQueue;

/**
 * @author DINESH KUMAR
 */
public class Tree {


    protected Node root;
    protected int size;

    public Tree() {
        root = null; size = 0;
    }


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
        System.out.print(root.data.key + "\n");

        printTreein2D(root.left, space);
    }

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
    public Node delete(Entry entry) {
        root = deleteNode(root, entry);
        return root;
    }

    private Node deleteNode(Node root, Entry entry) {
        if (root == null) {
            return null;
        }

        if (equals(root.data, entry)) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);

            root.right = deleteNode(root.right, root.data);
        } else {
            root.left = deleteNode(root.left, entry);
            root.right = deleteNode(root.right, entry);
        }
        return root;
    }

    private Entry minValue(Node root) {
        Entry minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

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

    protected boolean equals(Entry e1, Entry e2){
        return (e1.key == e2.key && e1.val == e2.val);
    }

    protected Node find( Entry entry){
        return findNode(root, entry);
    }

}
