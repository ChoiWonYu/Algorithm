package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ2629 {

    static boolean[][] dp;
    static int[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        c = new int[n];
        dp = new boolean[n + 1][400001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            String answer = dp[n][target] ? "Y" : "N";
            sb.append(answer).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static void dfs(final int idx, final int sum) {
        if(dp[idx][sum])return;
        dp[idx][sum] = true;
        if (idx == c.length) {
            return;
        }
        dfs(idx + 1, sum);
        dfs(idx + 1, sum + c[idx]);
        dfs(idx + 1, Math.abs(sum - c[idx]));
    }
}
