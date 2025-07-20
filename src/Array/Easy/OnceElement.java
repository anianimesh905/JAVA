package src.Array.Easy;

import java.util.HashMap;
import java.util.Map;

// 🚀 QUESTION:
// Given an array of integers, where some elements appear more than once,
// print all the elements that appear only once.
// ➤ Approach 1: Use HashMap to count frequency.
// ➤ Approach 2 (Optimized for 1 unique): Use XOR (only works if exactly one element appears once).

public class OnceElement {

    static void once(int[] arr){
        HashMap<Integer, Integer> m = new HashMap<>();

        // ✅ Standard way using getOrDefault (cleaner and correct)
        for(int i : arr){
            m.put(i, m.getOrDefault(i, 0) + 1);
        }

        // ✅ Alternate way using containsKey (your version with explanation)
        /*
        for(int i : arr){
            if (!m.containsKey(i))
                m.put(i, 1);  // First occurrence stored as 1, which is correct too
            else if(m.containsKey(i))
                m.put(i, m.getOrDefault(i, 0) + 1);  // Will give 2 on second occurrence
        }
        */

        // ✅ Print elements that occurred only once
        for(Map.Entry<Integer, Integer> t : m.entrySet()){
            if(t.getValue() == 1)
                System.out.println(t.getKey());
        }

        // ✅ Better solution using XOR (works only when exactly one element appears once)
//        int xor = 0;
//        for (int i : arr){
//            xor = xor ^ i;
//        }
//        System.out.println(xor);
    }

    public static void main(String[] args) {
        int[] num = {4, 3, 1, 2, 1, 2};
        once(num);  // Expected Output: 4, 3
    }
}
