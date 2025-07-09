package src.Heap;

public class MaxHeapDemo {

    static class MaxHeap{
        private int[] heap;
        private int size;

        public MaxHeap(int capacity){
            heap = new int[capacity];
            size = 0;
        }

        private int parent(int i){
            return (i-1)/2;
        }

        private int left(int i){
            return 2*i + 1;
        }

        private int right(int i){
            return 2*i + 2;
        }

        public void insert(int val){
            if (size == heap.length){
                System.out.println("Heap is full");
                return ;
            }
            heap[size] = val;
            int i = size++;
            while(i>0 && heap[i] > heap[parent(i)]){
                swap(i, parent(i));
                i = parent(i);
            }
        }

        public int deleteMax(){
            if(size == 0){
                System.out.println("Heap is empty");
                return Integer.MIN_VALUE; // return 0 = [10, 2, 3, 0, 25]
            }
            int max = heap[0];
            heap[0] = heap[--size];
            heapifyDown(0);
            return max;
        }

        private void heapifyDown(int i) {
            int largest = i; // assume the current node is the largest

            int l = left(i), r = right(i); // get indices of left and right children

            // If left child exists and is greater than current largest, update largest
            if (l < size && heap[l] > heap[largest])
                largest = l;

            // If right child exists and is greater than current largest, update largest
            if (r < size && heap[r] > heap[largest])
                largest = r;

            // If the largest is not the current node, we must swap and recurse
            if (largest != i) {
                swap(i, largest);          // move the bigger child up
                heapifyDown(largest);      // fix the subtree below recursively
            }
        }

        private void swap(int i, int j){
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void printHeap() {
            System.out.print("Heap: ");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10); // capacity = 10

        // 🔢 Inserting elements
        heap.insert(15);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        heap.printHeap(); // Heap before deletion

        // 🗑️ Delete Max and show result
        System.out.println("Deleted Max: " + heap.deleteMax());
        heap.printHeap();

        System.out.println("Deleted Max: " + heap.deleteMax());
        heap.printHeap();
    }
}
