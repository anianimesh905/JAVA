package src.Array.Easy;

public class RotateArray {

    static void leftRotate(int[] arr, int n){
        int[] arr1 = new int[n];
        int i;
        for (i = 0; i<n; i++)
            arr1[i] = arr[i];

        for (i = 0; i < arr.length - n; i++){
            arr[i] = arr[i + n];
        }

        for (i = 0; i < n; i++){
            arr[n+i+1] = arr1[i];
        }

        for (int j : arr){
            System.out.print(j + " ");
        }

    }

    static void rightRotate(int[] arr, int n){
        int[] arr1 = new int[n];
        int i;

        n = n % arr.length;

        for (i = 0; i<n; i++)
            arr1[i] = arr[n+1+i];
//            arr1[i] = arr[arr.length - n + 1];

        for (i = arr.length - 1; i >= n; i--){
            arr[i] = arr[i - n];
        }

        for (i = 0; i < n; i++){
            arr[i] = arr1[i];
        }

        for (int j : arr){
            System.out.print(j + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};
        System.out.println("Left rotate");
        leftRotate(arr1, 2);
        System.out.println();
        System.out.println("Right rotate");
        rightRotate(arr2, 2);
    }
}
