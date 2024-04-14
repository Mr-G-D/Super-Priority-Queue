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

//    protected void setTree(Node node){
//        root = node;
//    }

//    void insertRec(Entry data) {
//        root = insertRec(root, data);
//    }
//
//
//    Node insertRec(Node root, Entry data) {
//        if (root == null) {
//            root = new Node(data);
//            return root;
//        }
//
//        if (data.key < root.data.key) {
//            root.left = insertRec(root.left, data);
//        } else if (data.key > root.data.key) {
//            root.right = insertRec(root.right, data);
//        }
//
//        return root;
//    }

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
    public Node delete(Node root, Entry entry) {
        int key = entry.key;
        if (root == null)
            return null;

        if (root.data.key > key) {
            root.left = delete(root.left, entry);
            return root;
        } else if (root.data.key < key) {
            root.right = delete(root.right, entry);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        } else {

            Node succParent = root;

            Node succ = root.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            root.data.key = succ.data.key;

            return root;
        }
    }

    public Node delete(Entry entry){
        return delete(root, entry);
    }

}
