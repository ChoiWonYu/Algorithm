package BOJ.swm;

import java.io.*;
import java.util.*;

public class B1012 {

    static int[] dx, dy;
    static boolean[][] visited;
    static int[][] map;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dx = new int[]{0, 0, 1, -1};
        dy = new int[]{1, -1, 0, 0};

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        result++;
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static void dfs(final int x, final int y) {
        for (int i = 0; i < dx.length; i++) {
            int curX = x + dx[i];
            int curY = y + dy[i];

            if (curX >= 0 && curX < n && curY >= 0 && curY < m &&
                !visited[curX][curY] && map[curX][curY] == 1) {
                visited[curX][curY] = true;
                dfs(curX, curY);
            }
        }
    }

}
