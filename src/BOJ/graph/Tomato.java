package BOJ.graph;

import java.io.*;
import java.util.*;

public class Tomato {

    static int n, m;
    static int[][] tomato;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tomato = new int[m][n];

        Deque<int[]> d = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    d.add(new int[]{i, j});
                }
            }
        }
        int day = -1;

        while (!d.isEmpty()) {
            day++;
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.poll();
                for (int j = 0; j < dx.length; j++) {
                    int curX = cur[0] + dx[j];
                    int curY = cur[1] + dy[j];

                    if (!isValid(curX, curY)) {
                        continue;
                    }

                    tomato[curX][curY] = 1;
                    d.add(new int[]{curX, curY});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day);
    }

    private static boolean isValid(final int x, final int y) {
        return x >= 0 && y >= 0 && x < m && y < n && tomato[x][y] == 0;
    }
}
