package src.Hashing;

import java.util.HashMap;
import java.util.Map;

// 💬 Q6. Given an array of integers, count the frequency of each element using HashMap.
// Output format: element -> frequency

public class Q6_Freq {

    // Function to count frequency of each element
    static void frequency(int[] arr, int n){
        HashMap<Integer, Integer> e = new HashMap<>();

        // Count occurrences of each element
        for (int i : arr){
            if(e.containsKey(i))
                e.put(i, e.get(i) + 1); // If already present, increase count
            else
                e.put(i, 1); // Else, set count as 1
        }

        // Print element and its frequency
        for(Map.Entry<Integer, Integer> entry : e.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1, 1, 2, 3, 3, 3};
        int n = arr.length;

        // Print original array
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        frequency(arr, n); // Call frequency function
    }
}
