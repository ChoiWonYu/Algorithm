package BOJ.random;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int[] pointers = new int[n];
        Arrays.fill(pointers, n - 1);

        int maxP = -1;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if (maxP != -1) {
                pointers[maxP]--;
                max = Integer.MIN_VALUE;
            }
            for (int j = 0; j < n; j++) {
                if (nums[pointers[j]][j] > max) {
                    maxP = j;
                    max = nums[pointers[j]][maxP];
                }
            }
        }
        System.out.println(max);
    }
}
