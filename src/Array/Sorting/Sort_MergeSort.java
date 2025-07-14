package src.Array.Sorting;
import java.util.ArrayList;
import java.util.*;

 /*
 Q: Sort an array using the Merge Sort algorithm.
 Sample Input:  arr = {9, 4, 7, 6, 3, 1, 5}
 Sample Output: 1 3 4 5 6 7 9

 Merge Sort Explanation:
 - Merge Sort is a Divide and Conquer algorithm.
 - It divides the array into two halves recursively until each part has only one element.
 - Then, it merges the sorted halves back together to get a fully sorted array.
 - Time Complexity: O(n log n)
 */

public class Sort_MergeSort {

    // This function merges two sorted halves of the array: [low...mid] and [mid+1...high]
    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary list to store merged result
        int left = low;      // pointer for left half
        int right = mid + 1; // pointer for right half

        // Compare elements from both halves and add the smaller one to temp
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Copy remaining elements from left half (if any)
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Copy remaining elements from right half (if any)
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy back the merged elements to the original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low); // adjust index because temp starts from 0
        }
    }

    // Recursive function to split the array
    public static void mergeSort(int[] arr, int low, int high) {
        // Base case: if only one element is left
        if (low >= high) return;

        int mid = (low + high) / 2;

        // Sort left half
        mergeSort(arr, low, mid);

        // Sort right half
        mergeSort(arr, mid + 1, high);

        // Merge both sorted halves
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = { 9, 4, 7, 6, 3, 1, 5 };

        System.out.println("Before sorting array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Call the mergeSort function with full range
        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After sorting array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
