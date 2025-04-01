package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2589 {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char cur = map[i][j];
                if (cur == 'L') {
                    answer = Math.max(answer, getMaxCntByBfs(n, m, map, i, j));
                }
            }
        }
        System.out.println(answer);
    }

    private static int getMaxCntByBfs(final int n, final int m, final char[][] map,
        final int ci, final int cj) {
        boolean[][] visited = new boolean[n][m];
        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{ci, cj});
        visited[ci][cj] = true;
        int maxDepth = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            maxDepth++;
            for (int i = 0; i < len; i++) {
                int[] cur = d.pollFirst();
                for (int j = 0; j < dx.length; j++) {
                    int nextX = cur[0] + dx[j];
                    int nextY = cur[1] + dy[j];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m
                        && map[nextX][nextY] == 'L' && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        d.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return maxDepth - 1;
    }

}
