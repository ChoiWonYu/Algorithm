package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ24418 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] arr = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] dp = new long[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i - 1][j - 1];
            }
        }

        System.out.println(dp[n][n]);
    }

}
