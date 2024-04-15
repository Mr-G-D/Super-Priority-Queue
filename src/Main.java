import Helpers.*;

/**
 * @author DINESH KUMAR
 */

public class Main {
    public static void main(String[] args) {
        SuperPriorityQueue heap = new SuperPriorityQueue("minheap");

        heap.insert(new Entry(10, 10));
        heap.insert(new Entry(20, 10));
        heap.insert(new Entry(30, 10));
        heap.insert(new Entry(40, 10));
        heap.insert(new Entry(50, 10));

        heap.printTreein2D();
        System.out.println(heap.size());
        System.out.println("_______________________________________");
        heap.replace(new Entry(10, 10), 100);
        System.out.println(heap.size());
        heap.printTreein2D();

//        Tree tree = new Tree();
//
//        tree.insertToTree(new Entry(10, 10));
//        tree.insertToTree(new Entry(20, 10));
//        tree.insertToTree(new Entry(30, 10));
//        tree.insertToTree(new Entry(40, 10));
//        tree.insertToTree(new Entry(50, 10));
//        tree.insertToTree(new Entry(60, 10));
//
//        System.out.println(tree.delete(new Entry(20, 10)).data.key);
//        tree.printTreein2D();
    }
}