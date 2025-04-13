package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2240 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] tree = new int[t];
        for (int i = 0; i < t; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[t + 1][w + 1];
        for (int i = 1; i <= t; i++) {
            int cur = tree[i - 1];
            dp[i][0] = cur == 1 ? dp[i - 1][0] + 1 : dp[i - 1][0];

            if (cur == 1) {
                for (int j = 1; j <= w; j++) {
                    if (j % 2 == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            } else {
                for (int j = 1; j <= w; j++) {
                    if (j % 2 == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= w; i++) {
            answer = Math.max(dp[t][i], answer);
        }
        System.out.println(answer);
    }

}
