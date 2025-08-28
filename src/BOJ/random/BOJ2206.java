package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2206 {

    static int n, m, answer;
    static int[][] map;
    static int[][][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        map = new int[n][m];
        dist = new int[2][n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        Deque<int[]> deque = new LinkedList<>();
        dist[0][0][0] = 1;
        deque.offer(new int[]{0, 0, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int r = cur[0];
            int c = cur[1];
            int broke = cur[2];
            if (r == n - 1 && c == m - 1) {
                System.out.println(dist[broke][r][c]);
                return;
            }
            for (int j = 0; j < 4; j++) {
                int nextR = cur[0] + dr[j];
                int nextC = cur[1] + dc[j];

                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) {
                    continue;
                }

                if (map[nextR][nextC] == 0 && dist[broke][nextR][nextC] == 0) {
                    dist[broke][nextR][nextC] = dist[broke][r][c] + 1;
                    deque.offer(new int[]{nextR, nextC, broke});
                    continue;
                }
                if (map[nextR][nextC] == 1 && broke == 0 && dist[broke][nextR][nextC] == 0) {
                    dist[1][nextR][nextC] = dist[broke][r][c] + 1;
                    deque.offer(new int[]{nextR, nextC, 1});
                }
            }
        }

        System.out.println(-1);
    }
}
