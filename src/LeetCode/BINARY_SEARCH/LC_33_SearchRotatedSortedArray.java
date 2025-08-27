package src.LeetCode.BINARY_SEARCH;

/**
 * LeetCode 33 - Search in Rotated Sorted Array
 *
 * Problem Statement:
 * You are given an integer array nums sorted in ascending order (with distinct values),
 * which is rotated at some pivot unknown to you beforehand.
 * Given the array nums and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 *
 * Example:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Goal:
 * Find the index of target in O(log n) time using modified binary search.
 */

public class LC_33_SearchRotatedSortedArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 🎯 Check if target found
            if (nums[mid] == target) return mid;

            // ✅ Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target lies in left half
                } else {
                    left = mid + 1; // target lies in right half
                }
            }
            // ✅ Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target lies in right half
                } else {
                    right = mid - 1; // target lies in left half
                }
            }
        }

        return -1; // Not found
    }

    // 🔍 Quick Test
    public static void main(String[] args) {
        LC_33_SearchRotatedSortedArray obj = new LC_33_SearchRotatedSortedArray();
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(obj.search(nums, 0));  // Output: 4
        System.out.println(obj.search(nums, 3));  // Output: -1
    }
}
