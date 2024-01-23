package BOJ.swm;

import java.io.*;
import java.util.*;

public class B2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            dp[nums[i]] += 1;
            for (int j = nums[i]; j <= k; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }

        System.out.println(dp[k]);
    }

}
