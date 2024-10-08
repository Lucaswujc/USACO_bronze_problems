package usaco_silver_basic;

import java.util.Scanner;

/**
 * Farmer John's N cows are standing in a row, as they have a tendency to do from time to time. Each
 * cow is labeled with a distinct integer ID number so FJ can tell them apart. FJ would like to take
 * a photo of a contiguous group of cows but, due to a traumatic childhood incident involving the
 * numbers 1…6, he only wants to take a picture of a group of cows if their IDs add up to a multiple
 * of 7. Please help FJ determine the size of the largest group he can photograph.
 * 
 * INPUT FORMAT (file div7.in):
 * 
 * The first line of input contains N (1≤N≤50,000). The next N lines each contain the N integer IDs
 * of the cows (all are in the range 0…1,000,000). OUTPUT FORMAT (file div7.out):
 * 
 * Please output the number of cows in the largest consecutive group whose IDs sum to a multiple of
 * 7. If no such group exists, output 0. You may want to note that the sum of the IDs of a large
 * group of cows might be too large to fit into a standard 32-bit integer. If you are summing up
 * large groups of IDs, you may therefore want to use a larger integer data type, like a 64-bit
 * "long long" in C/C++.
 */

public class SequencesSummingToSevens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        long prefixSum = 0;
        int[] cowArray = new int[N];
        long[] prefixSums = new long[N + 1];
        for (int i = 0; i < N; i++) {
            int cow = scan.nextInt();
            cowArray[i] = cow;
            prefixSum += cow;
            prefixSums[i + 1] = prefixSum;
        }
        int maxRegion = 0;
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < i; j++) {
                if ((prefixSums[i] - prefixSums[j]) % 7 == 0) {
                    maxRegion = i - j > maxRegion ? i - j : maxRegion;
                }
            }
        }
        System.out.println(maxRegion);
        scan.close();
    }
}
