package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBDistance2 {

    private final static int LARGE_NUM = 1000 * 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] amount = new int[n][3];
        long[][] dp;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                amount[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long answer = Integer.MAX_VALUE;

        for (int k = 0; k < 3; k++) {
            dp = new long[n][3];
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    dp[0][i] = amount[0][i];
                } else {
                    dp[0][i] = LARGE_NUM;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + amount[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + amount[i][1];
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + amount[i][2];
            }

            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    continue;
                }
                answer = Math.min(answer, dp[n - 1][i]);
            }
        }

        System.out.println(answer);
    }

}
