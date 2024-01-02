package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BitonicNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[][] dp = new int[n][n];
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {

            int maxLLength = 0;

            for (int k = 0; k < i; k++) {
                int lLength = 0;
                if (nums[i] <= nums[k]) {
                    dp[i][k] = 0;
                    continue;
                }
                for (int j = 0; j < k; j++) {
                    if (nums[i] > nums[k] && nums[k] > nums[j]) {
                        lLength = Math.max(lLength, dp[i][j]);
                    }
                }
                dp[i][k] = lLength + 1;
                maxLLength = Math.max(maxLLength, dp[i][k]);
            }

            int maxRLength = 0;

            for (int k = i + 1; k < n; k++) {
                int rLength = 0;
                if (nums[i] <= nums[k]) {
                    dp[i][k] = 0;
                    continue;
                }
                for (int j = i; j < k; j++) {
                    if (nums[i] > nums[k] && nums[k] < nums[j]) {
                        rLength = Math.max(rLength, dp[i][j]);
                    }
                }
                dp[i][k] = rLength + 1;
                maxRLength = Math.max(maxRLength, dp[i][k]);
            }

            result = Math.max(result, maxLLength + maxRLength + 1);
        }

//        int result = 0;
//        for (int i = 0; i < n; i++) {
//            result = Math.max(result, dp[i][n - 1]);
//        }

        System.out.println(result);
    }

}
