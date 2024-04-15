import Helpers.*;

/**
 * @author DINESH KUMAR
 */

/**
 * Main class to test the SuperPriorityQueue

 */
public class Main {
    /**
     * Main method to test the SuperPriorityQueue
     * @param args command line arguments
     */
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

        heap.removeTop();
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.remove(new Entry(40, 10));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.insert(new Entry(40, 10));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceKey(new Entry(40, 10), 400);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.insert(new Entry(400, 10));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceKey(new Entry(400, 10), 25);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.toggle();
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.insert(new Entry(40, 10));
        heap.insert(new Entry(500, 20));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.remove(new Entry(40, 10));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.insert(new Entry(40, 10));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceKey(new Entry(40, 10), 400);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.insert(new Entry(400, 10));
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceKey(new Entry(400, 10), 25);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printTreein2D();
        System.out.println("---------------------------------------");
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printTreein2D();
    }
}