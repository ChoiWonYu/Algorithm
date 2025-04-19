package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ5557 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        long[][] dp = new long[100][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][nums[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            // plus
            for (int j = nums[i]; j <= 20; j++) {
                dp[i][j] += dp[i - 1][j - nums[i]];
            }

            // minus
            for (int j = 0; j <= 20 - nums[i]; j++) {
                dp[i][j] += dp[i - 1][j + nums[i]];
            }
        }

        System.out.println(dp[n - 2][nums[n - 1]]);
        br.close();
    }
}
