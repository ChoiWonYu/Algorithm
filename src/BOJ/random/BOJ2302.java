package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2302 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 1;

        int[] dp = new int[n + 1];
        boolean[] isVip = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            isVip[vip] = true;
        }

        dp[0] = 1;
        dp[1] = 1;

        if (n >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (isVip[i]) {
                answer *= dp[cnt];
                cnt = 0;
            } else {
                cnt++;
            }
        }
        answer *= dp[cnt];
        System.out.println(answer);
    }
}
