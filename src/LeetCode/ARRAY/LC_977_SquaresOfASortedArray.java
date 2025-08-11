package src.LeetCode.ARRAY;

import java.util.Arrays;

/*
LeetCode Problem #977 - Squares of a Sorted Array

Problem Statement:
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Approach:
1. Create a new array to store the squares.
2. Loop through nums and store the square of each element in the new array.
3. Sort the squared array using Arrays.sort().
4. Return the sorted array.

Time Complexity: O(n log n) due to sorting.
Space Complexity: O(n) for the new array.

Dry Run:
nums = [-4, -1, 0, 3, 10]
Step 1: Square → [16, 1, 0, 9, 100]
Step 2: Sort → [0, 1, 9, 16, 100]
Return result.
*/

public class LC_977_SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];

        // Step 1: Square each number
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] * nums[i];
        }

        // Step 2: Sort the squared values
        Arrays.sort(arr);

        return arr;
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_977_SquaresOfASortedArray solution = new LC_977_SquaresOfASortedArray();
        int[] result = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(result)); // [0, 1, 9, 16, 100]
    }
}
