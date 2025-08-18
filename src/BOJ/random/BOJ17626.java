package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ17626 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        List<Integer> muls = new ArrayList<>();
        int mul = 1;
        while (mul * mul <= n) {
            dp[mul * mul] = 1;
            muls.add(mul * mul);
            mul++;
        }
        for (int i = 1; i <= n; i++) {
            for (int j : muls) {
                if (i + j > n) {
                    break;
                }
                dp[i + j] = Math.min(dp[i + j], dp[j] + dp[i]);
            }
        }
        System.out.println(dp[n]);
    }

}
