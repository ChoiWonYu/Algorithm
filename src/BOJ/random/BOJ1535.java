package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1535 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int limit = 100;

        int[] hp = new int[n + 1];
        int[] happy = new int[n + 1];
        int[][] dp = new int[n + 1][limit];

        StringTokenizer hpst = new StringTokenizer(br.readLine());
        StringTokenizer happySt = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            hp[i] = Integer.parseInt(hpst.nextToken());
            happy[i] = Integer.parseInt(happySt.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < limit; j++) {
                if (j >= hp[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - hp[i]] + happy[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n][limit - 1]);
    }
}
