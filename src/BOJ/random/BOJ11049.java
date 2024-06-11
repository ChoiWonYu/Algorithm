package BOJ.random;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fNum = Integer.parseInt(st.nextToken());
            arr[i] = fNum;
            if (i == n - 1) {
                arr[i + 1] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                int end = j + i;
                dp[j][end] = Integer.MAX_VALUE;
                for (int k = j; k < end; k++) {
                    dp[j][end] = Math.min(dp[j][end],
                        dp[j][k] + dp[k + 1][end] + arr[j] * arr[k + 1] * arr[end + 1]);
                }
            }
        }

        sb.append(dp[0][n - 1]);
        System.out.println(sb);
    }
}
