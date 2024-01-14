package BOJ.graph;

import java.io.*;
import java.util.*;

public class Island {

    static int w, h;
    static boolean[][] visited;
    static int[][] island;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] dx = new int[]{0, 0, 1, -1, 1, 1, -1, -1};
        int[] dy = new int[]{1, -1, 0, 0, 1, -1, 1, -1};

        int cnt;
        Deque<int[]> d;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            d = new LinkedList<>();

            island = new int[h][w];
            visited = new boolean[h][w];
            cnt = 0;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (visited[i][j] || island[i][j] == 0) {
                        continue;
                    }
                    d.add(new int[]{i, j});
                    visited[i][j] = true;
                    cnt++;
                    while (!d.isEmpty()) {
                        int[] cur = d.poll();
                        for (int k = 0; k < dx.length; k++) {
                            if (!isValid(cur, dx[k], dy[k])) {
                                continue;
                            }
                            int curX = cur[0] + dx[k];
                            int curY = cur[1] + dy[k];

                            visited[curX][curY] = true;
                            d.add(new int[]{curX, curY});
                        }
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isValid(final int[] target, final int plusX, final int plusY) {
        int targetX = target[0] + plusX;
        int targetY = target[1] + plusY;

        return targetX >= 0 && targetY >= 0 && targetX < h && targetY < w
            && !visited[targetX][targetY] && island[targetX][targetY] != 0;
    }

}
