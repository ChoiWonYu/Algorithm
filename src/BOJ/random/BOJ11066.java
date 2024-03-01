package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int T = 0; T < t; T++) {
            int n = Integer.parseInt(br.readLine());
            int[] sumArr = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                int cur = Integer.parseInt(st.nextToken());
                sumArr[i] = sumArr[i - 1] + cur;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = i - 1; j >= 1; j--) {
                    dp[j][i] = Integer.MAX_VALUE;
                    for (int p = j; p < i; p++) {
                        dp[j][i] = Math.min(dp[j][i],
                            dp[j][p] + dp[p + 1][i]);
                    }
                    dp[j][i] += sumArr[i] - sumArr[j - 1];
                }
            }

            sb.append(dp[1][n]).append("\n");
        }
        System.out.println(sb);
    }
}
