package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Grape {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] volumes = new int[n];

        long[][] dp = new long[n][3];
        for (int i = 0; i < n; i++) {
            volumes[i] = Integer.parseInt(br.readLine());
        }

        dp[0][1] = volumes[0];
        dp[0][0] = volumes[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1] + volumes[i];
            dp[i][1] = dp[i - 1][2] + volumes[i];
            dp[i][2] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]),
                dp[i - 1][2]);

        }

        long max = Arrays.stream(dp[n - 1])
            .max()
            .getAsLong();

        System.out.println(max);
    }

}
