package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2410 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int mul = 2;
        while (mul <= n) {
            for (int i = mul; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - mul]) % 1000000000;
            }
            mul *= 2;
        }

        System.out.println(dp[n] % 1000000000);
    }
}
