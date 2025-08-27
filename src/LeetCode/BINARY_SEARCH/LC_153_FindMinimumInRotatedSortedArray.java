package src.LeetCode.BINARY_SEARCH;

/**
 * LC_153_FindMinimumInRotatedSortedArray
 *
 * Problem Statement:
 * Suppose an array of length n is sorted in ascending order and then rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 *   - [4,5,6,7,0,1,2] if it was rotated 4 times.
 *
 * Given the sorted rotated array nums of unique elements,
 * return the minimum element of this array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 *
 * Example 3:
 * Input: nums = [11,13,15,17]
 * Output: 11
 *
 * Approach:
 * - Use binary search.
 * - Compare mid with right element:
 *   - If nums[mid] > nums[right], min must be in right half.
 *   - Else, min is in left half (including mid).
 * - Keep shrinking search space until left == right.
 */
public class LC_153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in right half
                left = mid + 1;
            } else {
                // Minimum is in left half (including mid)
                right = mid;
            }
        }
        return nums[left]; // or nums[right], both same
    }

    // Test the solution
    public static void main(String[] args) {
        LC_153_FindMinimumInRotatedSortedArray sol = new LC_153_FindMinimumInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(sol.findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(sol.findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(sol.findMin(nums3)); // 11
    }
}