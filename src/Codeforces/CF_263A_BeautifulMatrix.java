package src.Codeforces;
import java.util.Scanner;

/**
 * A. Beautiful Matrix (Codeforces 263A)
 *
 * Problem:
 * A 5x5 matrix contains exactly one '1' and rest are '0'.
 * Find the minimum number of moves to bring '1' to the center (3,3).
 *
 * Example:
 * Input:
 * 0 0 0 0 0
 * 0 0 0 0 1
 * 0 0 0 0 0
 * 0 0 0 0 0
 * 0 0 0 0 0
 *
 * Output:
 * 3
 *
 * Approach:
 * - Read the 5x5 matrix.
 * - Find position (row, col) of '1'.
 * - Compute Manhattan Distance to (3,3).
 */

public class CF_263A_BeautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];
        int x=0,y=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    x=i;
                    y=j;
                }
            }
        }
        System.out.print(Math.abs(x - 2) + Math.abs(y - 2));
    }
}
