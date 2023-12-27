package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {

    public static int[] dp = new int[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        int max, answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
