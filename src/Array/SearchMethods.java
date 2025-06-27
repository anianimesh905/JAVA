package src.Array;
import java.util.Arrays;

public class SearchMethods {

    // 🔍 Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;  // Element found at index i
        }
        return -1;  // Element not found
    }

    // 🔍 Binary Search (works only on sorted array)
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target)
                return mid;  // Element found
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;  // Element not found
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};
        int target = 8;

        // 🔎 Linear Search
        int result1 = linearSearch(arr, target);
        System.out.println("Linear Search: Element found at index " + result1);

        // 📌 Binary Search needs sorted array
        Arrays.sort(arr);
        int result2 = binarySearch(arr, target);
        System.out.println("Binary Search (on sorted array): Element found at index " + result2);
    }
}
