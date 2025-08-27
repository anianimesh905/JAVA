package src.LeetCode.BINARY_SEARCH;

/*
LeetCode 34. Find First and Last Position of Element in Sorted Array

Problem:
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Example:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Approach:
- Use binary search twice.
- First binary search finds the leftmost (first) occurrence.
- Second binary search finds the rightmost (last) occurrence.
- Time Complexity: O(log n)
*/

public class LC_34_FindFirstAndLast {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        res[0] = first(nums, target);
        res[1] = last(nums, target);
        return res;
    }

    // Find first occurrence of target
    public int first(int[] nums, int target) {
        int st = 0, end = nums.length - 1, res = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                res = mid;
                end = mid - 1; // keep searching left
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return res;
    }

    // Find last occurrence of target
    public int last(int[] nums, int target) {
        int st = 0, end = nums.length - 1, res = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target) {
                res = mid;
                st = mid + 1; // keep searching right
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return res;
    }

    // Test main
    public static void main(String[] args) {
        LC_34_FindFirstAndLast obj = new LC_34_FindFirstAndLast();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ans = obj.searchRange(nums, target);
        System.out.println("[" + ans[0] + ", " + ans[1] + "]"); // [3,4]
    }
}
