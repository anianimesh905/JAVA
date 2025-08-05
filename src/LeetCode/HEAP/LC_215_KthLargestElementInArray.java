// LC_215_KthLargestElementInArray.java
// ✅ LeetCode 215 - Kth Largest Element in an Array

/*
🔸 Problem:
Given an integer array `nums` and an integer `k`, return the kth largest element in the array.

Note:
- The array is **not** necessarily sorted.
- You must return the element that would be in the (n - k)th index if sorted.

🔹 Example:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5  → The 2nd largest element is 5
*/

package src.LeetCode.HEAP;

import java.util.PriorityQueue;

public class LC_215_KthLargestElementInArray {

    // 🔹 Function to find the kth largest element in the array
    public int findKthLargest(int[] nums, int k) {
        // ✅ Create a min-heap (smallest element is at the top)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 🔁 Iterate through all elements in the array
        for (int num : nums) {
            minHeap.add(num);  // ➕ Add current number to the min-heap

            // ❌ If heap size exceeds k, remove the smallest element
            // ✅ This keeps only the k largest elements in the heap
            if (minHeap.size() > k) {
                minHeap.poll(); // 🧹 Removes the smallest of the k+1 elements
            }
        }

        // ✅ After processing all numbers, the top of the heap is the kth largest
        return minHeap.peek();  // 👑 Return kth largest (smallest among the top k)
    }

    // 🔸 Main method for testing
    public static void main(String[] args) {
        LC_215_KthLargestElementInArray solution = new LC_215_KthLargestElementInArray();

        int[] nums = {3, 2, 1, 5, 6, 4}; // 🔢 Input array
        int k = 2;                       // 📍 We want the 2nd largest element

        int result = solution.findKthLargest(nums, k); // ⚙️ Call the method
        System.out.println("The " + k + "th largest element is: " + result); // 🖨️ Output: 5
    }
}
