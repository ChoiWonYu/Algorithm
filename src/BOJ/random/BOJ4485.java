package BOJ.random;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BOJ4485 {

    public static void main(String[] args) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[][] dp = new int[n][n];
            int[][] arr = new int[n][n];
            Deque<int[]> d = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[0][0] = arr[0][0];
            d.add(new int[]{0, 0});
            while (!d.isEmpty()) {
                int len = d.size();
                for (int i = 0; i < len; i++) {
                    int[] cur = d.poll();
                    for (int k = 0; k < 4; k++) {
                        int nextR = cur[0] + dr[k];
                        int nextC = cur[1] + dc[k];
                        if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n
                            || dp[cur[0]][cur[1]] + arr[nextR][nextC] >= dp[nextR][nextC]) {
                            continue;
                        }
                        dp[nextR][nextC] = dp[cur[0]][cur[1]] + arr[nextR][nextC];
                        d.add(new int[]{nextR, nextC});
                    }
                }
            }
            System.out.println("Problem " + idx++ + ": " + dp[n - 1][n - 1]);
        }
    }

}
