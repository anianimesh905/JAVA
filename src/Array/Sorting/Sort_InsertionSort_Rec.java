package src.Array.Sorting;

public class Sort_InsertionSort_Rec {

    static void insertionSort(int[] arr, int low, int high){
        if(low == high)
            return;

        int next = low;
        while (next > 0 && arr[next - 1] > arr[next]){
            int  temp = arr[next - 1];
            arr[next - 1] = arr[next];
            arr[next] = temp;
            next--;
        }
        insertionSort(arr, low + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,1,3,5,7};
        System.out.println("Before");
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("After");
        insertionSort(arr, 0, arr.length);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
