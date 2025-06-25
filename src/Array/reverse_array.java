package src.Array;
import java.util.Arrays;
public class reverse_array {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 3};

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}