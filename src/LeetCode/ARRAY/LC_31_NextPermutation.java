package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 31. Next Permutation
 *
 * Problem:
 * Rearranges numbers into the lexicographically next greater permutation.
 * If not possible, rearrange to the lowest order (sorted ascending).
 *
 * Example:
 * Input: [1,2,3]
 * Output: [1,3,2]
 *
 * Approach (Two Pointers):
 * 1. Find the first decreasing element from right (pivot).
 * 2. Find the next larger element to swap with pivot.
 * 3. Swap them.
 * 4. Reverse the suffix after pivot to get smallest sequence.
 */

public class LC_31_NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find pivot (first decreasing element from right)
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) { // if pivot found
            int j = n - 1;
            // Step 2: Find next larger element from right
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix (i+1 to end)
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_31_NextPermutation obj = new LC_31_NextPermutation();

        int[] nums1 = {1,2,3};
        obj.nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [1,3,2]

        int[] nums2 = {3,2,1};
        obj.nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1,2,3]

        int[] nums3 = {1,1,5};
        obj.nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1,5,1]
    }
}

/**
 * ✅ Time Complexity: O(n) (single pass + reverse)
 * ✅ Space Complexity: O(1) (in-place)
 */
