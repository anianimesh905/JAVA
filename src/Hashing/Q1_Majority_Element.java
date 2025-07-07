/*
 * Majority Element
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Example 1:
 * nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
 * Output: 1
 *
 * Example 2:
 * nums[] = {1, 2};
 * Output: 1, 2
 */

package src.Hashing;

import java.util.HashMap;
import java.util.Map;

public class Q1_Majority_Element {

    public static void majorityEle(int[] num){
        int n = num.length;
        HashMap<Integer, Integer> e = new HashMap<>();
        for(int i : num){
            if(e.containsKey(i))
                e.put(i, e.get(i) + 1);
            else
                e.put(i, 1);
        }

        System.out.println(e);

        for(Map.Entry<Integer, Integer> m : e.entrySet()){
            if(m.getValue() > n/3)
                System.out.print(m.getKey() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num = {1,3,2,5,1,3,1,5,1};
        int[] num1 = {1,2};
        majorityEle(num);
        majorityEle(num1);
    }
}
