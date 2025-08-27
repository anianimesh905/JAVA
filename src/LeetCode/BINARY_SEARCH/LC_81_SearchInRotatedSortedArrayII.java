package src.LeetCode.BINARY_SEARCH;

/*
 🔶 LeetCode 81 - Search in Rotated Sorted Array II

 🔹 Problem Statement:
 You are given an integer array nums which is sorted in non-decreasing order
 and rotated at some pivot. The array may contain duplicates.
 Return true if target exists in nums, otherwise return false.

 🔸 Example:
 Input:  nums = [2,5,6,0,0,1,2], target = 0
 Output: true

 Input:  nums = [2,5,6,0,0,1,2], target = 3
 Output: false

 ✅ Goal:
 Use a modified binary search to handle duplicates and determine
 if the target exists in the rotated array.
*/

public class LC_81_SearchInRotatedSortedArrayII {

    // ✅ Binary Search with Duplicate Handling
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) return true; // Found target

            // 🔑 Case 1: Duplicates on both ends
            // Example: [1,1,1,0,1]
            // Here, nums[low] == nums[mid] == nums[high],
            // so we cannot decide which half is sorted.
            // To break the tie, shrink the search space.
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // 🔑 Case 2: Left half is sorted
            else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;  // Search left
                } else {
                    low = mid + 1;   // Search right
                }
            }
            // 🔑 Case 3: Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;   // Search right
                } else {
                    high = mid - 1;  // Search left
                }
            }
        }

        return false; // Target not found
    }

    // 🧪 Test the code
    public static void main(String[] args) {
        LC_81_SearchInRotatedSortedArrayII sol = new LC_81_SearchInRotatedSortedArrayII();

        int[] nums1 = {2,5,6,0,0,1,2};
        System.out.println(sol.search(nums1, 0)); // ✅ true
        System.out.println(sol.search(nums1, 3)); // ✅ false

        int[] nums2 = {1,0,1,1,1};
        System.out.println(sol.search(nums2, 0)); // ✅ true (duplicate case)
    }
}
