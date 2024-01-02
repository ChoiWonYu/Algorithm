package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillingTile {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(0);
            return;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;

        for (int i = 2; i <= n; i += 2) {
            dp[i] = dp[i - 2] == 0 ? 3 : dp[i - 2] * 3;

            if (i >= 4) {
                int m = 2;
                while (2 * m <= i) {
                    dp[i] += dp[i - 2 * m] == 0 ? 2 : (dp[i - 2 * m] * 2);
                    m += 1;
                }
            }
        }

        System.out.println(dp[n]);
    }

}
