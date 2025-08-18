package src.Array.Easy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Remove Duplicates from Array
 *
 * 1. deleteDupSorted() - Two pointer method (for sorted arrays)
 * 2. deleteDupUnsorted() - Using LinkedHashSet (for unsorted arrays)
 */
public class DeleteDuplicate {

    // ✅ Method 1: Two-pointer approach (sorted arrays only)
    static int deleteDupSorted(int[] num) {
        if (num.length == 0) return 0;

        int i = 0; // pointer for unique elements
        for (int j = 1; j < num.length; j++) {
            if (num[i] != num[j]) {
                i++;
                num[i] = num[j]; // move unique element forward
            }
        }
        return i + 1; // unique element count
    }

    // ✅ Method 2: Using LinkedHashSet (works for unsorted arrays too)
    static int[] deleteDupUnsorted(int[] num) {
        Set<Integer> set = new LinkedHashSet<>(); // keeps order
        for (int n : num) {
            set.add(n);
        }
        // Convert set back to array
        int[] result = new int[set.size()];
        int index = 0;
        for (int n : set) {
            result[index++] = n;
        }
        return result;
    }

    public static void main(String[] args) {

        // Example 1: Sorted array
        int[] sortedArr = {1, 2, 3, 4, 4, 4, 5};
        int uniqueCount = deleteDupSorted(sortedArr);
        System.out.println("Sorted Array Unique Elements: " + Arrays.toString(Arrays.copyOf(sortedArr, uniqueCount)));
        System.out.println("Unique Count: " + uniqueCount);

        // Example 2: Unsorted array
        int[] unsortedArr = {4, 5, 9, 4, 1, 5, 2};
        int[] uniqueUnsorted = deleteDupUnsorted(unsortedArr);
        System.out.println("Unsorted Array Unique Elements: " + Arrays.toString(uniqueUnsorted));
        System.out.println("Unique Count: " + uniqueUnsorted.length);
    }
}
