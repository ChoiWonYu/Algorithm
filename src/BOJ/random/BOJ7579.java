package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][100001];
        int[] memories = new int[n];
        int[] costs = new int[n];
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st2.nextToken());
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int memory = memories[i];
            int cost = costs[i];
            for (int j = 0; j <= 10000; j++) {
                if (i == 0) {
                    if (j >= cost) {
                        dp[i][j] = memory;
                    }
                } else {
                    if (j >= cost) {
                        dp[i][j] = Math.max(dp[i - 1][j - cost] + memory, dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                if (dp[i][j] >= m) {
                    result = Math.min(result, j);
                }
            }
        }
        System.out.println(result);
    }
}
