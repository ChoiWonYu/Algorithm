package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2229 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int max, min;
            max = min = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                dp[i + 1] = Math.max(dp[i + 1], dp[j] + max - min);
            }
        }

        System.out.println(dp[n]);
    }

}
