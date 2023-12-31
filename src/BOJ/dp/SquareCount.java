package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareCount {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int limit = 0;

        while (Math.pow(limit + 1, 2) <= n) {
            limit += 1;
        }

        int[] squares = new int[limit];
        for (int i = 0; i < limit; i++) {
            squares[i] = (int) Math.pow(i + 1, 2);
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] += dp[i - 1] + 1;
        }

        for (int i = 0; i < squares.length; i++) {
            for (int j = squares[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j - squares[i]] + 1, dp[j]);
            }
        }

        System.out.println(dp[n]);
    }

}
