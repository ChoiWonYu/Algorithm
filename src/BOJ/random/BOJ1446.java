package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1446 {

    public static int n, d;
    public static int[] dp;
    public static int[][] distArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        dp = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dp[i] = i;
        }

        distArr = new int[d][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            distArr[i] = new int[]{start, end, dist};
        }
        for (int i = 0; i < n; i++) {
            int start = distArr[i][0];
            int end = distArr[i][1];
            int dist = distArr[i][2];
            if (start <= d && end <= d) {
                dfs(end, dp[start] + dist);
            }
        }

        System.out.println(dp[d]);
    }

    public static void dfs(int cur, int drive) {
        if (cur > d) {
            return;
        }
        if (drive >= dp[cur]) {
            return;
        }

        dp[cur] = drive;
        dfs(cur + 1, dp[cur] + 1);
        for (int i = 0; i < distArr.length; i++) {
            int start = distArr[i][0];
            if (start != cur) {
                continue;
            }

            int end = distArr[i][1];
            int dist = distArr[i][2];
            dfs(end, dp[cur] + dist);
        }
    }

}
