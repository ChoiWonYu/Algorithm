package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4811 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[31][31];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= 30; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            sb.append(dp[n][n]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
