package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 287. Find the Duplicate Number
 *
 * Problem Statement:
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive,
 * return the duplicate number.
 *
 * There is only one repeated number in nums, but it could be repeated more than once.
 * You must solve the problem without modifying the array nums and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:
 * Input: nums = [1,1]
 * Output: 1
 *
 * Goal:
 * Find the duplicate number in the array.
 *
 * Approach (Floyd's Cycle Detection / Tortoise & Hare Algorithm):
 * ---------------------------------------------------------------
 * 1. Imagine the array as a "linked list":
 *    - Each index is a node
 *    - The value at that index tells you the "next node"
 *
 *    Example: nums = [1,3,4,2,2]
 *    Path: 0 → 1 → 3 → 2 → 4 → 2 → 4 → ... (cycle!)
 *    The cycle exists because of the duplicate number (2).
 *
 * 2. Step 1: Detect the cycle
 *    - Use two pointers (slow = 1 step, fast = 2 steps).
 *    - They will eventually meet inside the cycle.
 *
 * 3. Step 2: Find the "entry point" of the cycle
 *    - Reset fast pointer to the start.
 *    - Move both slow and fast by 1 step each.
 *    - Where they meet again is the duplicate number.
 */

public class LC_287_FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        // Step 1: Detect cycle using Floyd's algorithm
        int slow = nums[0]; // tortoise starts at nums[0]
        int fast = nums[0]; // hare also starts at nums[0]

        // Keep moving until they meet inside the cycle
        do {
            slow = nums[slow];          // move 1 step
            fast = nums[nums[fast]];    // move 2 steps
        } while (slow != fast);

        // Step 2: Find entry point of cycle (duplicate number)
        fast = nums[0]; // reset fast to the start
        while (slow != fast) {
            slow = nums[slow]; // move 1 step
            fast = nums[fast]; // move 1 step
        }

        // When slow == fast again → that's the duplicate number
        return slow;
    }

    // Test the implementation
    public static void main(String[] args) {
        LC_287_FindDuplicateNumber obj = new LC_287_FindDuplicateNumber();

        int[] nums1 = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums1)); // 2

        int[] nums2 = {3,1,3,4,2};
        System.out.println(obj.findDuplicate(nums2)); // 3

        int[] nums3 = {1,1};
        System.out.println(obj.findDuplicate(nums3)); // 1

        int[] nums4 = {1,4,6,3,2,5,6};
        System.out.println(obj.findDuplicate(nums4)); // 6
    }
}

/**
 * Time Complexity:
 * - O(n): Each pointer moves at most n steps.
 *
 * Space Complexity:
 * - O(1): Constant extra space (no modifications to input array).
 */
