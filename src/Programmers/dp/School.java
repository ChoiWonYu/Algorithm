package Programmers.dp;

public class School {

    public int solution(int m, int n, int[][] puddles) {
        int[][] w = new int[n][m];
        for (int i = 0; i < puddles.length; i++) {
            int pc = puddles[i][0] - 1;
            int pr = puddles[i][1] - 1;
            w[pr][pc] = 1;
        }
        int[][] dp = new int[n][m];
        int[] dr = new int[]{0, 1};
        int[] dc = new int[]{1, 0};

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int d = 0; d < dr.length; d++) {
                    int r = i + dr[d];
                    int c = j + dc[d];
                    if (r >= n || c >= m || w[r][c] == 1) {
                        continue;
                    }
                    dp[r][c] = (dp[r][c] + dp[i][j]) % 1_000_000_007;
                }
            }
        }
        return dp[n - 1][m - 1] % 1_000_000_007;
    }
}
