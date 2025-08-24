package src.Codeforces;

import java.util.Scanner;

/**
 * CF_231A_Team
 *
 * Problem Statement:
 * One day three friends Petya, Vasya and Tonya decided to form a team.
 * They will solve a problem if at least two of them are sure about it.
 *
 * Input:
 * n (number of problems)
 * followed by n lines of 3 integers (0 or 1) for Petya, Vasya, Tonya.
 *
 * Output:
 * Number of problems they will solve.
 *
 * Example:
 * Input:
 * 3
 * 1 1 0
 * 1 1 1
 * 1 0 0
 *
 * Output:
 * 2
 */
public class CF_231A_Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of problems
        int solved = 0;

        for (int i = 0; i < n; i++) {
            int petya = sc.nextInt();
            int vasya = sc.nextInt();
            int tonya = sc.nextInt();

            int sum = petya + vasya + tonya;
            if (sum >= 2) {
                solved++;
            }
        }

        System.out.println(solved);
    }
}
