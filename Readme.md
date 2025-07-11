# **SuperPriorityQueue: A Flexible Priority Queue with Min-Heap and Max-Heap Support**

Welcome to the **SuperPriorityQueue** project! This implementation is a highly flexible priority queue that can toggle between a **Min-Heap** and **Max-Heap** structure, offering powerful capabilities for dynamically managing priorities. Whether you're working with small datasets or large-scale priority-based operations, this project provides a robust solution for your queue management needs.

---

## **Features**
- **Toggle Between Min-Heap and Max-Heap**: Switch the heap type dynamically to suit your needs. The queue structure can adapt to both increasing and decreasing priority elements with ease.
- **Insertion & Removal Operations**: Insert entries with unique priorities and values. Efficiently remove the top entry or a specific entry from the heap.
- **Key and Value Replacement**: Replace the key or value of any entry in the queue, making it flexible for dynamic priority updates.
- **Level-order Heap Traversal**: Visualize the heap structure in breadth-first order using the `printBFS()` function for easy debugging and analysis.
- **Customizable & Extensible**: Easy to integrate with other applications, extend functionality, or build more complex heap structures.

---

## **How It Works**

### **SuperPriorityQueue**
- **Heap Type**: You can initialize the queue as either a **Min-Heap** or **Max-Heap**.
- **Toggle**: Switch the heap type dynamically, maintaining the heap properties through re-insertion of the elements.
- **Insertions and Removals**: Insert entries with a key and value, remove the top or a specific entry, and manage priorities efficiently.
- **Replace Key/Value**: Replace an entry’s priority (key) or its associated value without disrupting the heap's integrity.

### **Entry Class**
- **Key**: The priority of the entry (used for heap ordering).
- **Value**: Associated data with the entry, which can be dynamically modified.

### **Helper Classes**
- **DoublyLinkedListQueue**: Used for managing a queue that helps in the breadth-first traversal during heap toggling.
- **Node**: Represents a node in the heap structure, containing data, left, and right child pointers.

---

## **Example Usage**

### **Min-Heap Example**

Create a **SuperPriorityQueue** instance with the "minheap" option:

```java
SuperPriorityQueue heap = new SuperPriorityQueue("minheap");

heap.insert(new Entry(10, 100));
heap.insert(new Entry(20, 200));
heap.insert(new Entry(5, 50));

heap.printBFS();  // Shows the heap structure

// Remove the top entry (min element)
heap.removeTop();
heap.printBFS();

// Toggle to Max-Heap and insert more elements
heap.toggle();
heap.insert(new Entry(40, 400));
heap.printBFS();
```

## **Operations Supported**

1. **Insert an Entry**: 
   - Insert an entry with a key and value into the heap. This adds the new element while maintaining the heap property.

2. **Remove Top**: 
   - Remove the top (minimum or maximum) entry from the heap. The heap will adjust itself to maintain its structure after removal.

3. **Remove Specific Entry**: 
   - Remove a specific entry from the heap based on its key and value. If the entry exists, it will be removed and the heap will reorganize itself.

4. **Replace Key**: 
   - Replace the key (priority) of an existing entry. The entry will be re-positioned in the heap to maintain heap properties after the key change.

5. **Replace Value**: 
   - Replace the value of an existing entry without affecting its position in the heap based on the priority.

6. **Toggle Heap Type**: 
   - Switch between Min-Heap and Max-Heap. The heap will be restructured according to the new heap type while retaining the elements.

7. **Check Heap State**: 
   - Query whether the current heap is a Min-Heap or Max-Heap. This helps you know the current ordering of elements.

8. **Check Empty**: 
   - Verify whether the heap is empty or contains entries. Useful for ensuring that operations like removal or access don't fail.

9. **Check Size**: 
   - Get the current size of the heap, i.e., the number of elements contained in the heap. This allows you to track the number of active entries in the heap.

---

## **Contributing**

We welcome contributions to enhance this project. If you'd like to improve the functionality, add new features, or fix bugs, please follow these steps:

1. Fork the repository to your GitHub account.
2. Create a new branch for your feature or bug fix (`git checkout -b feature-xyz`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-xyz`).
5. Open a pull request to the main repository for review.

---

## **Acknowledgements**

- This project was developed as part of an academic assignment.
- Developed by **Dinesh Kumar Gopinathan** and **Sanjay Bharathi Subramanian**.

