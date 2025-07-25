package src.Array;

import java.util.ArrayList;
import java.util.List;

public class SubArray {

    static void subArr(int[] arr){
        List<List<Integer>> subarrays = new ArrayList<>();
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            List<Integer> temp = new ArrayList<>();
            for (int end = start; end < n; end++) {
                temp.add(arr[end]);                       // Extend subarray
                subarrays.add(new ArrayList<>(temp));     // Store snapshot
            }
        }

        System.out.println("All Subarrays:");
        for (List<Integer> sub : subarrays) {
            System.out.println(sub);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,7,4,9,2,7,4};
        subArr(arr);
    }
}
