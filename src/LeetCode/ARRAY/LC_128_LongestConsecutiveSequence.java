package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 128. Longest Consecutive Sequence
 *
 * Problem Statement:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive sequence is [1,2,3,4].
 *
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Goal:
 * Find the length of the longest consecutive sequence.
 *
 * Approaches:
 * 1. HashSet (O(n)): Use a set to expand sequences from their starting number.
 * 2. Sorting (O(n log n)): Sort and scan while skipping duplicates.
 */

public class LC_128_LongestConsecutiveSequence {

    // ✅ Method 1: Optimal HashSet solution (O(n))
    public int longestConsecutive_HashSet(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int maxLen = 0;

        for (int num : set) {
            // check if it's the start of a sequence
            if (!set.contains(num - 1)) {
                int curr = num;
                int streak = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    streak++;
                }

                maxLen = Math.max(maxLen, streak);
            }
        }

        return maxLen;
    }

    // ✅ Method 2: Sorting-based solution (O(n log n))
    public int longestConsecutive_Sorting(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);
        int cnt = 1;  // current streak
        int max = 1;  // longest streak found

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue; // skip duplicates
            } else if (nums[i + 1] == nums[i] + 1) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 1; // reset streak
            }
        }

        return max;
    }

    // Test the implementations
    public static void main(String[] args) {
        LC_128_LongestConsecutiveSequence obj = new LC_128_LongestConsecutiveSequence();

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("HashSet: " + obj.longestConsecutive_HashSet(nums1)); // 4
        System.out.println("Sorting: " + obj.longestConsecutive_Sorting(nums1)); // 4

        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println("HashSet: " + obj.longestConsecutive_HashSet(nums2)); // 9
        System.out.println("Sorting: " + obj.longestConsecutive_Sorting(nums2)); // 9
    }
}

/**
 * Time Complexity:
 * - HashSet: O(n)
 * - Sorting: O(n log n)
 *
 * Space Complexity:
 * - HashSet: O(n)
 * - Sorting: O(1) (if ignoring sort's internal space)
 */
