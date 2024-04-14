import Helpers.*;

/**
 * @author DINESH KUMAR
 */

public class Main {
    public static void main(String[] args) {
        SuperPriorityQueue heap = new SuperPriorityQueue("maxheap");

        heap.insert(new Entry(10, 10));
        heap.insert(new Entry(20, 10));
        heap.insert(new Entry(50, 10));
        heap.insert(new Entry(30, 10));
        heap.insert(new Entry(60, 10));
        heap.insert(new Entry(30, 10));

        heap.printTreein2D();
        System.out.println("-----------------------");
        heap.toggle();
        heap.printTreein2D();
    }
}