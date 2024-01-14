package BOJ.graph;

import java.io.*;
import java.util.*;

public class Maze {

    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = input.charAt(j) - 48;
            }
        }

        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{0, 0});

        int cnt = 0;
        int lv = 1;
        int lvCnt = 1;
        while (!d.isEmpty()) {
            if (cnt == lvCnt) {
                lvCnt = d.size();
                lv++;
                cnt = 0;
            }
            int[] cur = d.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                break;
            }
            for (int i = 0; i < dx.length; i++) {
                int curX = cur[0] + dx[i];
                int curY = cur[1] + dy[i];
                if (!isValid(curX, curY)) {
                    continue;
                }

                visited[curX][curY] = true;
                d.add(new int[]{curX, curY});
            }
            cnt++;
        }

        System.out.println(lv);
    }

    private static boolean isValid(final int curX, final int curY) {
        return curX >= 0 && curY >= 0 && curX < n && curY < m && !visited[curX][curY]
            && maze[curX][curY] == 1;
    }
}
