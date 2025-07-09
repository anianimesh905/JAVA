package src.Heap;

public class MinHeapDemo {

    //  Inner class to represent Min Heap
    static class MinHeap {
        private int[] heap; // Array to store heap elements
        private int size;   // Current number of elements in the heap

        //  Constructor: Initializes heap with a given capacity
        public MinHeap(int capacity) {
            heap = new int[capacity];
            size = 0;
        }

        //  Helper Methods to find parent and children of a node
        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1; }
        private int right(int i) { return 2 * i + 2; }

        //  Insert a new value into the Min Heap
        public void insert(int val) {
            if (size == heap.length) {
                System.out.println("Heap is full");
                return;
            }

            // Step 1: Add the new element at the end of the heap
            heap[size] = val;
            int i = size;
            size++; // Increase the heap size

            // Step 2: Bubble up to maintain the Min Heap property
            while (i > 0 && heap[i] < heap[parent(i)]) {
                swap(i, parent(i));
                i = parent(i); // Move up to the parent's index
            }
        }

        //  Delete the minimum element (root of the heap)
        public int deleteMin() {
            if (size == 0)
                throw new RuntimeException("Heap is empty");

            // Step 1: Store the min (root)
            int min = heap[0];

            // Step 2: Move the last element to root
            heap[0] = heap[--size]; // Reduce size after taking the last element

            // Step 3: Heapify down to maintain Min Heap property
            heapifyDown(0);

            return min; // Return deleted minimum
        }

        //  Heapify down from index `i`
        private void heapifyDown(int i) {
            int smallest = i; // Assume current node is smallest
            int l = left(i);  // Left child
            int r = right(i); // Right child

            // Find the smallest among node, left child and right child
            if (l < size && heap[l] < heap[smallest]) smallest = l;
            if (r < size && heap[r] < heap[smallest]) smallest = r;

            // If the smallest is not the current node, swap and recurse
            if (smallest != i) {
                swap(i, smallest);
                heapifyDown(smallest);
            }
        }

        //  Swap elements at indices i and j
        private void swap(int i, int j) {
            int tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

        //  Print the heap (level-order)
        public void printHeap() {
            System.out.print("Heap: ");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }

    // Main Method to test the MinHeap class
    public static void main(String[] args) {
        // Create a MinHeap with capacity 10
        MinHeap heap = new MinHeap(10);

        // Insert elements into the heap
        heap.insert(15);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        // Print the heap after insertions
        heap.printHeap(); // Should print the heap in min-heap order

        // Delete the smallest element (root) and print the heap
        System.out.println("Deleted Min 1: " + heap.deleteMin());
        heap.printHeap();

        // Delete again
        System.out.println("Deleted Min 2: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 3: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 4: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 5: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 6: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 7: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 8: " + heap.deleteMin());
        heap.printHeap();
        // Delete again
        System.out.println("Deleted Min 9: " + heap.deleteMin());
        heap.printHeap();
    }
}
