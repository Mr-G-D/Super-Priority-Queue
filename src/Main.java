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
        heap.insert(new Entry(60, 10));
        heap.insert(new Entry(70, 10));
        heap.insert(new Entry(80, 10));
        heap.insert(new Entry(90, 10));
        heap.insert(new Entry(100, 10));

        heap.printTreein2D();
        System.out.println("_______________________________________");
        Entry temp = heap.removeNode(new Entry(40, 10));
        System.out.println(temp.key);
        heap.printTreein2D();


    }
}