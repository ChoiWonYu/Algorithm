package inflearn.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stair {

    static int[] memo = new int[36];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo[1] = 1;
        memo[2] = 2;

        int result = stair(n);
        System.out.println(result);
    }

    private static int stair(final int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        return stair(n - 2) + stair(n - 1);
    }
}
