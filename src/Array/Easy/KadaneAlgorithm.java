package src.Array.Easy;

/*
    ✅ Question:
    Given an integer array, find the contiguous subarray (containing at least one number)
    which has the largest sum and return its sum and the subarray itself.

    🔍 Example:
    Input:  [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Subarray: [4, -1, 2, 1]

    ✅ Concept:
    This is a classic problem solved using Kadane's Algorithm. It runs in O(n) time and
    keeps track of the maximum subarray sum found so far while iterating through the array.
*/

public class KadaneAlgorithm {

    // Method to find and print the maximum subarray and its sum using Kadane's Algorithm
    static void findMaxSubarray(int[] arr) {
        int n = arr.length;

        // Initialize maxSum and currSum with the first element
        int maxSum = arr[0];  // Stores the maximum sum found so far
        int currSum = arr[0]; // Stores the current running sum of subarray

        // Variables to track subarray indices
        int start = 0, end = 0;       // Final start and end of max sum subarray
        int tempStart = 0;           // Temp start index for current subarray

        // Traverse the array from the second element
        for (int i = 1; i < n; i++) {

            // Decide whether to start a new subarray or continue with the existing
            if (currSum + arr[i] < arr[i]) {
                currSum = arr[i];        // Start new subarray
                tempStart = i;           // Reset temp start index
            } else {
                currSum += arr[i];       // Continue the subarray
            }

            // Update maxSum and final subarray indices if needed
            if (currSum > maxSum) {
                maxSum = currSum;        // New maximum found
                start = tempStart;       // Update start of subarray
                end = i;                 // Update end of subarray
            }
        }

        // Output result
        System.out.println("Maximum Subarray Sum = " + maxSum);
        printSubarray(arr, start, end); // Print the subarray itself
    }

    // Method to print subarray between given start and end indices
    static void printSubarray(int[] arr, int start, int end) {
        System.out.print("Subarray: [");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i]);           // Print element
            if (i < end) System.out.print(", "); // Add comma if not last element
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Test input array
        findMaxSubarray(arr); // Call the method to find max subarray
    }
}
