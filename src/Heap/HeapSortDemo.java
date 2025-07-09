package src.Heap;

public class HeapSortDemo {

    static class HeapSort{
        public void sort(int[] arr){
            int n = arr.length;

            for (int i = n/2 - 1; i>=0; i--)
                heapify(arr, n, i);

            for (int i = n-1; i>0; i--)
            {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, i, 0);
            }
        }

        public void heapify(int[] arr, int n, int i){
            int largest = i;
            int left = 2*i + 1;
            int right = 2*i + 2;

            if (left < n && arr[left] > arr[largest])
                largest = left;
            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != i){
                int temp = arr[largest];
                arr[largest] = arr[i];
                arr[i] = temp;

                heapify(arr, n, largest);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 10, 3, 5, 1};

        System.out.println("Orginal array");
        for (int i : arr)
            System.out.print(i + " ");

        HeapSort hs = new HeapSort();
        hs.sort(arr);

        System.out.println("\n\nSorted array using HeapSort:");
        for (int num : arr)
            System.out.print(num + " ");

    }

}
