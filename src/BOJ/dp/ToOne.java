package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ToOne {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        Arrays.fill(dp, 1000001);
        dp[1] = 0;

        for (int j = 2; j <= n; j++) {
            if (j % 3 == 0) {
                dp[j] = Math.min(dp[j], dp[j / 3] + 1);
            }
            if (j % 2 == 0) {
                dp[j] = Math.min(dp[j], dp[j / 2] + 1);
            }
            dp[j] = Math.min(dp[j], dp[j - 1] + 1);
        }

        System.out.println(dp[n]);
    }
}
