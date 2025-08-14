package BOJ.random;

import java.util.Scanner;

public class BOJ11048 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dr = new int[]{-1, 0, -1};
        int[] dc = new int[]{0, -1, -1};

        int[][] dp = new int[n][m];
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = map[i][j];
                for (int k = 0; k < 3; k++) {
                    int x = i + dr[k];
                    int y = j + dc[k];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[x][y]);
                }
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }

}
