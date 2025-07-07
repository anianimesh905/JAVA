/*
 * Given two integer arrays, find their intersection (common unique elements).
 *
 * Example:
 * Input:  arr1 = {1, 2, 3}, arr2 = {2, 3, 4}
 * Output: {2, 3}
 */

package src.Hashing;

import java.util.HashSet;

public class Q3_IntersectionOfArrays {
    public static void intersection(int[] n1, int[] n2){
        HashSet<Integer> e = new HashSet<>();
        HashSet<Integer> r = new HashSet<>();
        for(int i : n1){
            e.add(i);
        }
        for (int i : n2){
            if (e.contains(i))
                r.add(i);
        }

        System.out.println(r);
    }
    public static void main(String[] args) {
        int[] n1 = {1,2,3};
        int[] n2 = {3,4,5};

        intersection(n1,n2);
    }
}
