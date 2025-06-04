package BOJ.random;

import java.util.Scanner;

public class BOJ15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        int[] tArr = new int[n];
        int[] pArr = new int[n];
        for (int i = 0; i < n; i++) {
            tArr[i] = sc.nextInt();
            pArr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int next = i + tArr[i];
            if (next > n) {
                continue;
            }
            dp[next] = Math.max(dp[next], dp[i] + pArr[i]);
        }
        System.out.println(dp[n]);
    }

}
