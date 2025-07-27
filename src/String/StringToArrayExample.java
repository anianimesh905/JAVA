package src.String;

import java.util.Arrays;

public class StringToArrayExample {
        public static void main(String[] args) {
            String str = "hello world";

            // Convert to char[]
            char[] charArray = str.toCharArray();
            System.out.println("Char Array: " + Arrays.toString(charArray));

            // Convert to String[] by splitting on space
            String[] wordArray = str.split(" ");
            System.out.println("Word Array: " + Arrays.toString(wordArray));

            // Convert to String[] of characters
            String[] charStringArray = str.split("");
            System.out.println("Char String Array: " + Arrays.toString(charStringArray));
        }
}
