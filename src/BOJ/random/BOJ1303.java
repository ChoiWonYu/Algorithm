package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1303 {

    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};
    public static char[][] war;
    public static boolean[][] visited;
    public static int n, m;
    public static int[] total = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        war = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                war[i][j] = input.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    int count = bfs(i, j);
                    if (war[i][j] == 'W') {
                        total[0] += (int)Math.pow(count, 2);
                    } else {
                        total[1] += (int)Math.pow(count, 2);
                    }
                }

            }
        }

        System.out.println(total[0] + " " + total[1]);
    }

    public static int bfs(int x, int y) {
        Deque<int[]> d = new LinkedList<>();
        d.add(new int[]{x, y});
        int count = 0;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.pollFirst();
                count++;
                for (int j = 0; j < 4; j++) {
                    int nextX = cur[0] + dx[j];
                    int nextY = cur[1] + dy[j];
                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]
                        && war[nextX][nextY] == war[x][y]) {
                        visited[nextX][nextY] = true;
                        d.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return count;
    }
}
