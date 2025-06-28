/*
 * This program checks whether a given number is a "lucky number".
 * A lucky number is defined as a number that contains only the digits 4 and 7.
 *
 * Steps:
 * 1. Read an integer input from the user.
 * 2. Extract each digit of the number using modulus and division.
 * 3. Check if each digit is either 4 or 7.
 *    - If any digit is not 4 or 7, mark the number as not lucky.
 * 4. If all digits are lucky, print "YES", otherwise print "NO".
 */

package src.Fundamental;
import java.util.*;

public class Lucky_number {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();

        int x = 0;
        int count = 0;
        while (a>0)
        {
            x = a%10;
            if (x!=4 && x!=7)
                count++;
            a=a/10;
        }
        if(count == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
