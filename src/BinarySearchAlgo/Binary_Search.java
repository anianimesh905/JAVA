package src.BinarySearchAlgo;

public class Binary_Search {

    static int binarySearch(int[] arr, int t, int low, int high){
        if (low > high)
            return -1;
        int mid = low+(high-low)/2;
        if(t==arr[mid])
            return mid;
        else if(t > arr[mid]){
            return binarySearch(arr, t, mid+1, high);
        }
        else
            return binarySearch(arr, t, low, mid-1);
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 17;
        int low = 0;
        int high = arr.length-1;
        if(binarySearch(arr, target, low, high) == -1)
            System.out.println("Not present");
        else
            System.out.println("Present");
    }
}
