package src.Array.Easy;

// 🚀 QUESTION:
// Given a binary array (containing only 0s and 1s), find the maximum number of consecutive 1s in the array.
// Example:
// Input: [1,1,0,1,1,1]
// Output: 3

public class MaxConsecutive {

    static void consecutive(int[] arr){
        int count = 0;
        int max = 0;
        for (int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1])   // If current element equals previous
                count++;             // Increase count
            else
                count = 0;           // Reset count if not consecutive
            max = Math.max(max, count);             // This keeps max value in max
        }
        System.out.println(max + 1); // Print the final result (+1 to include the first 1)
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,1,1};
        consecutive(arr);
    }
}
