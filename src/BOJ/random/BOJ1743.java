package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1743 {

    public static int n, m, k;
    public static int[] dx = new int[]{0, 0, -1, 1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public static boolean[][] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        route = new boolean[n][m];
        int r, c;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            route[r - 1][c - 1] = true;
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (route[i][j]) {
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    public static int bfs(int r, int c) {
        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{r, c});
        int result = 0;
        route[r][c] = false;

        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.pollFirst();
                result++;
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + dx[j];
                    int nextY = cur[1] + dy[j];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                        && route[nextX][nextY]) {
                        d.add(new int[]{nextX, nextY});
                        route[nextX][nextY] = false;
                    }
                }
            }
        }

        return result;
    }
}
