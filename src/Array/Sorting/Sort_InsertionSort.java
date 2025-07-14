/*
=> Q: Sort an array using **Insertion Sort** algorithm.
- Sample Input: arr = {13, 46, 24, 52, 20, 9}
- Sample Output: 9 13 20 24 46 52

=> Insertion Sort Explanation:
- Think of sorting cards in your hand.
- Start from the second element and compare it with elements before it.
- Shift elements one step to the right until you find the correct spot to insert the current element.
- Repeat this for all elements in the array.
*/

package src.Array.Sorting;

public class Sort_InsertionSort {
    public static void insertionSort(int[] arr) {
        // Traverse from the 1st index to the end
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            // Move elements that are greater than arr[j] one position ahead
            while (j > 0 && arr[j - 1] > arr[j]) {
                // Swap arr[j] and arr[j-1] to bring smaller element forward
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j--; // Move to the left for more comparisons/swaps if needed
            }
        }

        // Print the sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9}; // input array
        insertionSort(arr); // call the sorting function
    }
}
