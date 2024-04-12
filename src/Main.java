
/**
 * @author DINESH KUMAR
 */

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap("minheap");

        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.insert(5);
        heap.insert(60);
        heap.insert(70);
        heap.insert(80);

        heap.printTreein2D();
    }
}