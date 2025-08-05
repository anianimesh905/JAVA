package src.LeetCode.HASHING;

import java.util.HashMap;
import java.util.Map;

/*
 🔶 LeetCode 169 - Majority Element
 🔹 Problem Statement:
 Given an array `nums` of size n, return the element that appears more than ⌊n / 2⌋ times.
 The input array is guaranteed to have a majority element.

 🔸 Example:
 Input:  nums = [2,2,1,1,1,2,2]
 Output: 2

 ✅ Note:
 A majority element is the element that appears more than n/2 times in the array.
 In this case, n = 7 → n/2 = 3.5 → majority element must appear more than 3 times.
 2 appears 4 times, so it is the majority element.

 🔍 Goal:
 Count how many times each element appears and return the one that crosses the n/2 threshold.
*/

public class LC_169_MajorityElement {

    // ✅ Method using HashMap to count frequencies
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count the frequency of each element
        for (int num : nums) {
            // If number is already present, increment its count
            // Else, initialize it with count = 1
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Iterate through map to find the element with count > n/2
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();  // ✅ Majority element found
            }
        }
        // 🚫 This should never happen as per problem guarantee
        return -1;
    }

    public static void main(String[] args) {
        LC_169_MajorityElement solution = new LC_169_MajorityElement();

        int[] nums = {2, 2, 1, 1, 1, 2, 2}; // Test input
        int result = solution.majorityElement(nums);

        // Expected Output: 2
        System.out.println("Majority Element: " + result);
    }
}
