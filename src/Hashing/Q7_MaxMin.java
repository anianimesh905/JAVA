package src.Hashing;

import java.util.*;

// 💬 Q7. Given an array of integers, find the element with the highest frequency
// and the element with the lowest frequency using HashMap.
// Print both the elements (not the frequency count).

public class Q7_MaxMin {

    public static void main(String args[]) {

        int arr[] = {10, 5, 10, 15, 10, 5};
        int n = arr.length;

        Frequency(arr, n); // Call the frequency function
    }

    // Function to find elements with highest and lowest frequency
    static void Frequency(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each element using HashMap
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1); // Increment existing count
            } else {
                map.put(arr[i], 1); // First occurrence
            }
        }

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

        // Step 2: Find the element with max and min frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();   // Frequency
            int element = entry.getKey();   // Element

            // Update max frequency and corresponding element
            if (count > maxFreq) {
                maxEle = element;
                maxFreq = count;
            }

            // Update min frequency and corresponding element
            if (count < minFreq) {
                minEle = element;
                minFreq = count;
            }
        }

        // Step 3: Print results
        System.out.println("The highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }
}
