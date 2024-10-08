package usaco_silver_basic;

import java.util.Scanner;

/**
 * Farmer John's N cows, conveniently numbered 1…N, are all standing in a row (they seem to do so
 * often that it now takes very little prompting from Farmer John to line them up). Each cow has a
 * breed ID: 1 for Holsteins, 2 for Guernseys, and 3 for Jerseys. Farmer John would like your help
 * counting the number of cows of each breed that lie within certain intervals of the ordering.
 * INPUT FORMAT (file bcount.in):
 * 
 * The first line of input contains N and Q (1≤N≤100,000, 1≤Q≤100,000). The next N lines contain an
 * integer that is either 1, 2, or 3, giving the breed ID of a single cow in the ordering.
 * 
 * The next Q lines describe a query in the form of two integers a,b (a≤b).
 * 
 * OUTPUT FORMAT (file bcount.out):
 * 
 * For each of the Q queries (a,b), print a line containing three numbers: the number of cows
 * numbered a…b that are Holsteins (breed 1), Guernseys (breed 2), and Jerseys (breed 3). SAMPLE
SAMPLE INPUT:

6 3
2
1
1
3
2
1
1 6
3 3
2 4
SAMPLE OUTPUT:

3 2 1
1 0 0
2 0 1
 */
public class BreedCount {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int Q = scan.nextInt();
        int[] cowsArray = new int[N];
        int[][] cowsPrefixCounts = new int[N + 1][3];
        for (int i = 0; i < N; i++) {
            int cowtype = scan.nextInt();
            cowsArray[i] = cowtype;
            System.arraycopy(cowsPrefixCounts[i], 0, cowsPrefixCounts[i + 1], 0, 3);
            cowsPrefixCounts[i + 1][cowtype - 1] += 1;
        }
        printPrefix(cowsPrefixCounts);
        StringBuffer answers = new StringBuffer();
        for (int i = 0; i < Q; i++) {
            int from = scan.nextInt() - 1;
            int to = scan.nextInt();

            for (int j = 0; j < 3; j++) {
                answers.append(cowsPrefixCounts[to][j] - cowsPrefixCounts[from][j]);
                answers.append(" ");
            }
            answers.append("\n");
        }
        System.out.println(answers.toString());
        scan.close();
    }

    private static void printPrefix(int[][] is) {
        System.out.println("\n============prefixsum============");
        for (int j = 0; j < is.length; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print(is[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("============prefixsum============");
    }

}
