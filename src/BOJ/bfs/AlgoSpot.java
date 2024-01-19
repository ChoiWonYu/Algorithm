package BOJ.bfs;

import java.io.*;
import java.util.*;

class Status {

    int brokenWall;
    int x;
    int y;

    public Status(final int x, final int y, final int brokenWall) {
        this.brokenWall = brokenWall;
        this.x = x;
        this.y = y;
    }
}

public class AlgoSpot {

    private static final int ZERO_ASCII = 48;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        boolean[][][] visited = new boolean[n][m][n * m + 1];
        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = (int) input.charAt(j) - ZERO_ASCII;
            }
        }

        Deque<Status> d = new LinkedList<>();
        d.add(new Status(0, 0, 0));
        int minWall = Integer.MAX_VALUE;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                Status cur = d.poll();
                if (cur.x == n - 1 && cur.y == m - 1) {
                    minWall = Math.min(minWall, cur.brokenWall);
                    continue;
                }

                for (int j = 0; j < dx.length; j++) {
                    int curX = cur.x + dx[j];
                    int curY = cur.y + dy[j];

                    if (curX < 0 || curX >= n || curY < 0 || curY >= m ||
                        visited[curX][curY][maze[curX][curY] == 1 ? cur.brokenWall + 1
                            : cur.brokenWall]) {
                        continue;
                    }

                    if (cur.brokenWall > minWall) {
                        continue;
                    }
                    visited[curX][curY][maze[curX][curY] == 1 ? cur.brokenWall + 1
                        : cur.brokenWall] = true;
                    if (maze[curX][curY] == 1) {
                        d.add(new Status(curX, curY, cur.brokenWall + 1));
                    } else {
                        d.add(new Status(curX, curY, cur.brokenWall));
                    }
                }
            }
        }

        System.out.println(minWall);
    }

}
