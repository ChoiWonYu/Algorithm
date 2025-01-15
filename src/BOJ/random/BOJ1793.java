package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1793 {

    public static final int N = 250;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] dp = new BigInteger[N + 1];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2].multiply(BigInteger.valueOf(2)).add(dp[i - 1]);
        }

        while (true) {
            String input = br.readLine();
            if (input == null) {
                return;
            }
            int n = Integer.parseInt(input);
            System.out.println(dp[n]);
        }
    }
}
