package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumDecomposition {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[][] dp = new long[n + 1][k + 1];

        // N = 1
        // K = 1 : 1
        // K = 2 : {0,1} {1,0} 2
        // K = 3 : {0,0,1} {0,1,0} {1,0,0} 3

        //N = 2
        //K = 1
        //K = 2 : {1,1} {2,0} {0,2} 3
        //K = 3 : {1,1,0} {0,1,1} {1,0,1} {2,0,0} {0,2,0} {0,0,2} 6

        //dp[n][k] = dp[n-1][k] + dp[n][k-1]
        for (int i = 1; i <= k; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] % 1_000_000_000;
            }
        }

        System.out.println(dp[n][k] % 1_000_000_000);
    }
}
