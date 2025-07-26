package src.LeetCode.ARRAY;// 🧠 LeetCode 1752: Check if Array Is Sorted and Rotated

/*
👉 QUESTION:
Given an array `nums`, return true if the array was originally sorted in non-decreasing order,
then rotated some number of times (possibly 0), otherwise return false.

Rotation means shifting elements circularly. For example:
Original sorted array: [1, 2, 3, 4, 5]
Rotation 1 → [5, 1, 2, 3, 4]
Rotation 2 → [4, 5, 1, 2, 3]
...and so on.

Example 1:
Input:  [3, 4, 5, 1, 2]
Output: true

Example 2:
Input:  [2, 1, 3, 4]
Output: false
*/

public class LC_1752_CheckSortAndRotated {

    // ✅ Function to check if array is sorted and rotated
    public static boolean check(int[] nums) {
        int count = 0; // count the number of drops (where nums[i] > nums[i+1])
        int n = nums.length; // store the length of array

        // Loop through each element in array
        for (int i = 0; i < n; i++) {
            // Use (i+1) % n to wrap around to start (circular array check)
            if (nums[i] > nums[(i + 1) % n]) {
                count++; // we found a drop (rotation point)
            }

            // If more than one drop is found, it's not sorted and rotated
            if (count > 1) {
                return false;
            }
        }

        // If zero or one drop is found, it is sorted and rotated
        return true;
    }

    // 🔍 Driver code to test
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2}; // sample input

        System.out.println(check(nums)); // Output: true
    }
}
