package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sticker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());
            long[][] dp = new long[n][3];
            int[][] nums = new int[n][2];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    nums[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = nums[0][0];
            dp[0][2] = nums[0][1];

            for (int j = 1; j < n; j++) {
                dp[j][0] = Math.max(dp[j - 1][0], Math.max(dp[j - 1][1], dp[j - 1][2]));
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 1][2]) + nums[j][0];
                dp[j][2] = Math.max(dp[j - 1][0], dp[j - 1][1]) + nums[j][1];
            }

            long max = Arrays.stream(dp[n - 1])
                .max()
                .getAsLong();

            sb.append(max).append("\n");
        }

        System.out.println(sb);

    }

}
