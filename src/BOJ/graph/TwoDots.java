package BOJ.graph;

import java.io.*;
import java.util.*;

public class TwoDots {

    static int n, m, startX, startY;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                startX = i;
                startY = j;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println("No");
    }

    private static void dfs(final int x, final int y, final char color, final int cnt) {

        for (int i = 0; i < dx.length; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX == startX && curY == startY && cnt >= 4) {
                System.out.println("Yes");
                System.exit(0);
            }

            if (!isValid(curX, curY, color)) {
                continue;
            }

            visited[curX][curY] = true;
            dfs(curX, curY, board[curX][curY], cnt + 1);
            visited[curX][curY] = false;
        }
    }

    private static boolean isValid(final int x, final int y, final char prevColor) {
        return x >= 0 && y >= 0 && x < n && y < m && board[x][y] == prevColor && !visited[x][y];
    }

}
