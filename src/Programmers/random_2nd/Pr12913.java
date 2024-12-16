package Programmers.random_2nd;

public class Pr12913 {

    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        dp[0] = land[0];
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int x = 0; x < 4; x++) {
                    if (j == x) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][x]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < 4; i++) {
            max = Math.max(dp[land.length - 1][i], max);
        }
        return max;
    }
}
