package BOJ.random;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2839 {

    static final int INF = 9999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 5) {
            dp[5] = 1;
        }
        for (int i = 6; i <= n; i++) {
            if (dp[i - 3] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }

}
