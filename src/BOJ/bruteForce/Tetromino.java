package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class Tetromino {

    static int[][] board;
    static int n, m, result = 0;
    static boolean[][] visited;
    static int[] xDir = new int[]{-1, 1, 0, 0};
    static int[] yDir = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(0, i, j, 0);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    private static void dfs(final int cnt, final int x, final int y, final int sum) {
        if (cnt == 3) {
            result = Math.max(result, sum + board[x][y]);
            return;
        }

        if (cnt == 1) {
            for (int i = 0; i < 4; i++) {
                if (!isValid(x + xDir[i], y + yDir[i])) {
                    continue;
                }
                for (int j = i + 1; j < 4; j++) {
                    if (!isValid(x + xDir[j], y + yDir[j])) {
                        continue;
                    }
                    result = Math.max(result,
                        sum + board[x][y] + board[x + xDir[i]][y + yDir[i]] + board[x + xDir[j]][y
                            + yDir[j]]);
                }
            }
        }

        for (int i = 0; i < 4; i++) {

            if (isValid(x + xDir[i], y + yDir[i])) {
                visited[x][y] = true;
                dfs(cnt + 1, x + xDir[i], y + yDir[i], sum + board[x][y]);
                visited[x][y] = false;
            }
        }
    }

    private static boolean isValid(final int x, final int y) {
        return x >= 0 && y >= 0 && x < n && y < m && !visited[x][y];
    }


}
