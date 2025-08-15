package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ14940 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    deque.add(new int[]{i, j});
                }
            }
        }

        int[][] dist = new int[n][m];
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                int[] cur = deque.poll();
                for (int j = 0; j < 4; j++) {
                    int nextR = cur[0] + dr[j];
                    int nextC = cur[1] + dc[j];
                    if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || map[nextR][nextC] != 1
                        || dist[nextR][nextC] > 0) {
                        continue;
                    }
                    dist[nextR][nextC] = dist[cur[0]][cur[1]] + 1;
                    deque.add(new int[]{nextR, nextC});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] == 0) {
                    if (map[i][j] == 1) {
                        sb.append(-1);
                    } else {
                        sb.append(0);
                    }
                } else {
                    sb.append(dist[i][j]);
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
