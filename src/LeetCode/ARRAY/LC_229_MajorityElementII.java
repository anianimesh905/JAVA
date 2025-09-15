package src.LeetCode.ARRAY;

import java.util.*;

/**
 * LeetCode 229. Majority Element II
 *
 * Problem Statement:
 * Given an integer array nums of size n, return all elements that appear more than ⌊n/3⌋ times.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 *
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 *
 * Goal:
 * Find all majority elements (appearing more than n/3 times).
 *
 * Approach 1 (Extended Boyer-Moore Voting Algorithm):
 * ---------------------------------------------------------------
 * 1. Observation:
 *    - There can be at most 2 majority elements (> n/3 times).
 *
 * 2. Step 1: Find candidates
 *    - Use two counters and two potential candidates.
 *    - Traverse nums:
 *      - If current num == candidate1 → increase count1
 *      - Else if current num == candidate2 → increase count2
 *      - Else if count1 == 0 → set candidate1 = num, count1 = 1
 *      - Else if count2 == 0 → set candidate2 = num, count2 = 1
 *      - Else decrease both count1 and count2
 *
 * 3. Step 2: Verify candidates
 *    - Count actual frequency of candidate1 and candidate2 in nums.
 *    - Add to result if frequency > n/3.
 *
 * Approach 2 (HashMap):
 * ---------------------------------------------------------------
 * 1. Use a HashMap to store frequency of each number.
 * 2. Traverse the map and collect elements with count > n/3.
 * 3. Simple to implement but requires O(n) extra space.
 */

public class LC_229_MajorityElementII {

    // ---------------- Approach 1: Boyer-Moore Voting Algorithm ----------------
    public List<Integer> majorityElement_BoyerMoore(int[] nums) {
        int cand1 = 0, cand2 = 0;
        int count1 = 0, count2 = 0;

        // Step 1: Find candidates
        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        // Step 3: Collect results
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(cand1);
        if (count2 > threshold) result.add(cand2);

        return result;
    }

    // ---------------- Approach 2: HashMap ----------------
    public List<Integer> majorityElement_HashMap(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;

        // Count frequencies
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Collect elements > n/3
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > threshold) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    // ---------------- Test Both Approaches ----------------
    public static void main(String[] args) {
        LC_229_MajorityElementII obj = new LC_229_MajorityElementII();

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};
        int[] nums4 = {1, 1, 1, 3, 3, 2, 2, 2};

        // Boyer-Moore
        System.out.println("Boyer-Moore:");
        System.out.println(obj.majorityElement_BoyerMoore(nums1)); // [3]
        System.out.println(obj.majorityElement_BoyerMoore(nums2)); // [1]
        System.out.println(obj.majorityElement_BoyerMoore(nums3)); // [1,2]
        System.out.println(obj.majorityElement_BoyerMoore(nums4)); // [1,2]

        // HashMap
        System.out.println("\nHashMap:");
        System.out.println(obj.majorityElement_HashMap(nums1)); // [3]
        System.out.println(obj.majorityElement_HashMap(nums2)); // [1]
        System.out.println(obj.majorityElement_HashMap(nums3)); // [1,2]
        System.out.println(obj.majorityElement_HashMap(nums4)); // [1,2]
    }
}

/**
 * Time Complexity:
 * - Boyer-Moore: O(n), two passes
 * - HashMap: O(n), two passes
 *
 * Space Complexity:
 * - Boyer-Moore: O(1), constant space
 * - HashMap: O(n), extra frequency map
 */
