package src.Array.Easy;

import java.util.HashMap;
import java.util.Map;

/*
🎯 QUESTION:
Given an integer array `arr[]`, find the **majority element**.
A majority element appears **at least n/2 times** in the array.

👉 Example:
Input:  arr[] = {4, 4, 2, 4, 3, 4, 4, 3, 2, 4}
Output: 4
Explanation: 4 appears 6 times in an array of size 10 (n/2 = 5)
*/

public class TheMajorityOccuringElement {

    static void majorityElement(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>(); // store frequency of each element

        // 🔁 Count frequency of each element
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // if not found, use 0 as default
        }

        // 🔍 Check which element occurs at least n/2 times
        for (Map.Entry<Integer, Integer> t : map.entrySet()) {
            if (t.getValue() >= (n / 2)) {
                System.out.println("Majority Element: " + t.getKey());
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 2, 4, 3, 4, 4, 3, 2, 4}; // input array
        majorityElement(arr); // function call
    }
}
