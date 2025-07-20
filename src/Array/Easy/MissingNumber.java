package src.Array.Easy;

import java.util.HashSet;

public class MissingNumber {

    static void missing(int[] nums){
        int n = nums.length;
        int total = n * (n + 1) / 2;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        System.out.println(total - sum);;
    }

    public static void main(String[] args) {
        int[] num = {0,1,2,3,4,5};
        missing(num);
    }
}
