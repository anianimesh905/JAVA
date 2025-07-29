// LC_26_RemoveDuplicatesFromSortedArray.java
// ✅ LeetCode 26 - Remove Duplicates from Sorted Array
// 🔸 Problem:
// Given a sorted integer array nums, remove the duplicates in-place such that each element appears only once
// and return the new length. Do not allocate extra space; modify the input array in-place.

// 🔹 Example:
// Input:  nums = [1,1,2]
// Output: 2, nums becomes [1,2,_]

package src.LeetCode.ARRAY;

import java.util.Arrays;

public class LC_26_RemoveDuplicatesFromSortedArray {

    // Function to remove duplicates from sorted array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // Points to last unique element

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;             // Move to next position for unique element
                nums[i] = nums[j]; // Copy unique value to the front
            }
        }

        return i + 1; // Number of unique elements
    }

    // Main method for testing
    public static void main(String[] args) {
        LC_26_RemoveDuplicatesFromSortedArray solution = new LC_26_RemoveDuplicatesFromSortedArray();

        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        int k = solution.removeDuplicates(nums);

        System.out.println("Number of unique elements: " + k);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
        // Output: [1, 2, 3, 4, 5]
    }
}
