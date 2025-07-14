package src.Array.Sorting;

public class Sort_BubbleSort_Rec {

    static void bubbleSort(int[] arr, int n){
        if(n == 1)
            return;

        for (int i = 0; i < n-1; i++){
            if (arr[i] > arr[i+1]){
                int  temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        bubbleSort(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,1,3,5,7};
        System.out.println("Before");
        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();

        System.out.println("After");
        bubbleSort(arr, arr.length);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
