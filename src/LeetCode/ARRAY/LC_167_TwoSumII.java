package src.LeetCode.ARRAY;

/*
 🔶 LeetCode 167 - Two Sum II - Input Array Is Sorted

 🔹 Problem:
 Given a 1-indexed array of integers `numbers` that is already **sorted in non-decreasing order**,
 find two numbers such that they add up to a specific target number.

 Return the indices of the two numbers (1-indexed) as an integer array answer of size 2.
 You may not use the same element twice.

 🔸 Example:
 Input: numbers = [2,7,11,15], target = 9
 Output: [1,2]

 🔹 Constraints:
 - Exactly one solution exists.
 - The input array is sorted.

 ✅ Approach:
 Use the two-pointer technique since the array is already sorted.
 Move the pointers inward based on the sum comparison.
*/

public class LC_167_TwoSumII {

    // ✅ Two-pointer approach
    public int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int end = numbers.length - 1;

        // Move pointers toward each other
        while (st < end) {
            int sum = numbers[st] + numbers[end];

            if (sum == target) {
                // Return 1-based indices
                return new int[]{st + 1, end + 1};
            } else if (sum > target) {
                end--;  // Need a smaller sum
            } else {
                st++;   // Need a bigger sum
            }
        }

        // This line should never be reached (per constraints)
        return new int[]{-1, -1};
    }

    // 🧪 Test the code
    public static void main(String[] args) {
        LC_167_TwoSumII solution = new LC_167_TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]"); // Expected: [1, 2]
    }
}
