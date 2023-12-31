package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGBDistance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] amount = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                amount[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][3];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = amount[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + amount[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + amount[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + amount[i][2];
        }

        long result = Arrays.stream(dp[n - 1])
            .min()
            .getAsLong();

        System.out.println(result);
    }

}
