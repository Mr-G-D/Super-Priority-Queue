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

        //Case 1: Creating a min heap

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

        heap.printBFS();
        System.out.println("_______________________________________");

        //Case 2: Removing top
        heap.removeTop();
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 3: Removing specific entry
        heap.remove(new Entry(40, 10));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 4: Inserting entry
        heap.insert(new Entry(40, 10));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 5: Replacing key
        heap.replaceKey(new Entry(40, 10), 400);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 6: Inserting new key
        heap.insert(new Entry(400, 10));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 7: Replacing new key
        heap.replaceKey(new Entry(400, 10), 25);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 8: Replacing value
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 9: Replace value
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 10: Removing non existing value
        heap.remove(new Entry(40, 10));

        //Case 11: Toggling to Max heap
        heap.toggle();
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 12: Inserting into max heap
        heap.insert(new Entry(40, 10));
        heap.insert(new Entry(500, 20));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 13: Removing from max heap
        heap.remove(new Entry(40, 10));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 14: Inserting same into max heap
        heap.insert(new Entry(40, 10));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 15: Replace key
        heap.replaceKey(new Entry(40, 10), 400);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 16: Insert duplicate key
        heap.insert(new Entry(400, 10));
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 17: Replace new key
        heap.replaceKey(new Entry(400, 10), 25);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 18: Replace value
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printBFS();
        System.out.println("---------------------------------------");

        //Case 19: Replace non existing value
        heap.replaceVal(new Entry(90, 10), 50);
        heap.printBFS();

        //Case 20: Removing non existing entry
        heap.remove(new Entry(40, 10));
    }
}