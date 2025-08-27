package src.LeetCode.BINARY_SEARCH;

/**
 * 540. Single Element in a Sorted Array
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 * except for one element which appears exactly once.
 *
 * Return the single element that appears only once.
 * Your solution must run in O(log n) time and O(1) space.
 *
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *
 * 🔹 Approach:
 * - Since the array is sorted, we can use binary search.
 * - Pairs occur in order:
 *     - Before the single element → first index of the pair is even.
 *     - After the single element → first index of the pair is odd.
 * - Use mid index and check:
 *     - If `mid` is even and `nums[mid] == nums[mid+1]` → single is on right.
 *     - If `mid` is odd and `nums[mid] == nums[mid-1]` → single is on right.
 *     - Otherwise, single is on left.
 */

public class LC_540_SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Ensure mid is even (align with pair start)
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair matches → single is on right
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    // Test
    public static void main(String[] args) {
        LC_540_SingleElementInSortedArray sol = new LC_540_SingleElementInSortedArray();

        int[] nums1 = {1,1,2,3,3,4,4,8,8};
        int[] nums2 = {3,3,7,7,10,11,11};

        System.out.println(sol.singleNonDuplicate(nums1)); // 2
        System.out.println(sol.singleNonDuplicate(nums2)); // 10
    }
}
