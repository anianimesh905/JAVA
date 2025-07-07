/*
 * Given two integer arrays, find their union (all unique elements from both).
 *
 * Example:
 * Input:  arr1 = {1, 2, 3}, arr2 = {3, 4, 5}
 * Output: {1, 2, 3, 4, 5}
 */

package src.Hashing;

import java.util.HashSet;

public class Q2_UnionOfTwoArray {

    public static void union(int[] n1, int[] n2){
        HashSet<Integer> e = new HashSet<>();
        for(int i : n1){
            e.add(i);
        }
        for (int i : n2){
            if (e.contains(i))
                continue;
            else
                e.add(i);
        }

        System.out.println(e);
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,3};
        int[] n2 = {3,4,5};

        union(n1,n2);
    }
}
