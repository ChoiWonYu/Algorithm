package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DecreasingNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int minLength = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[i] < nums[j]) {
                    minLength = Math.max(minLength, dp[j]);
                }
            }
            dp[i] += minLength + 1;
        }

        int result = Arrays.stream(dp)
            .max()
            .getAsInt();

        System.out.println(result);
    }

}
