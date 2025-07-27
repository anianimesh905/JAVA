package src.Array.Easy;

// 🚀 QUESTION:
// Write a Java program to move all 0s in an array to the end while maintaining the order of non-zero elements as much as possible.
// You can use the two-pointer approach without using extra space.

public class ZeroToLast {

    static void zero(int[] arr){
        int i = 0;                      // Left pointer starting from beginning
        int j = arr.length - 1;        // Right pointer starting from end

        while (i < j){
            if (arr[i] == 0){          // If left element is 0
                while(arr[j] == 0){    // Move right pointer leftwards until a non-zero is found
                    j--;
                }
                if(arr[j] != 0){       // If right element is non-zero, swap with left
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            i++;                       // Move left pointer forward
        }

        // Print the updated array
        for (int k : arr)
            System.out.print(k + " ");
    }

    public static void main(String[] args) {
        // Test array with multiple 0s and non-zero values
        int[] arr = {0,1,0,3,12};
        zero(arr);                     // Call the zero function to move zeros to the end
    }
}
