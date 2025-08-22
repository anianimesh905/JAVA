package src.Array.Medium;

/**
 * 2149. Rearrange Array Elements by Sign
 *
 * Problem:
 * You are given a 0-indexed integer array nums of even length consisting of
 * an equal number of positive and negative integers.
 *
 * Rearrange the elements of nums such that every positive integer is followed by a
 * negative integer and their relative order is preserved.
 *
 * Example:
 * Input: nums = [3,1,-2,-5,2,-4]
 * Output: [3,-2,1,-5,2,-4]
 *
 * Approach:
 * - Separate positives and negatives
 * - Merge alternatively while keeping order
 */
public class RearrangeArrayBySign {

    public static int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int posIndex = 0, negIndex = 1; // positives go to even, negatives to odd positions

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] ans = rearrangeArray(nums);

        System.out.print("Output: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
}
