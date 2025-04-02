package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2591 {

    static final int MAX = 34;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length() + 1;
        int[] dp = new int[len];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < len; i++) {
            String one = num.substring(i - 1, i);
            if (isValid(Integer.parseInt(one), false)) {
                dp[i] += dp[i - 1];
            }
            String target = num.substring(i - 2, i);
            if (isValid(Integer.parseInt(target), true)) {
                dp[i] += dp[i - 2];
            }
        }

        System.out.println(dp[len - 1]);
    }

    static boolean isValid(int num, boolean flag) {
        return num >= 1 && num <= MAX && num / 10 >= 1 == flag;
    }
}
