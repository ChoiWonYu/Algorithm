package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContinuosSum2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[n][2];
        long result = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + nums[i], dp[i - 1][0]);

            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(result);
    }

}
