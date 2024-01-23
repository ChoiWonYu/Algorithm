package BOJ.swm;

import java.io.*;
import java.util.*;

public class B2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        long[][] dp = new long[n][3];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][2] = dp[i - 1][1] + nums[i];
        }

        long max = 0;

        for (int i = 1; i < 3; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);
    }

}
