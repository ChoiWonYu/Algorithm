package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ3190 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        int k = Integer.parseInt(br.readLine());
        int[][] dirArr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dIdx = 0;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = true;
        }
        int l = Integer.parseInt(br.readLine());
        String[] dir = new String[10001];
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            dir[t] = d;
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        int answer = 0;
        int dr, dc;
        while (true) {
            answer++;

            int[] head = snake.peekLast();
            dr = dirArr[dIdx][0];
            dc = dirArr[dIdx][1];
            int nextR = head[0] + dr;
            int nextC = head[1] + dc;
            int[] next = new int[]{nextR, nextC};

            if (!(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC])) {
                System.out.println(answer);
                return;
            }
            visited[nextR][nextC] = true;

            if (!board[nextR][nextC]) {
                int[] tail = snake.pollFirst();
                visited[tail[0]][tail[1]] = false;
            } else {
                board[nextR][nextC] = false;
            }
            snake.add(next);

            if (Objects.isNull(dir[answer])) {
                continue;
            }
            if (dir[answer].equals("D")) {
                dIdx = (dIdx + 5) % 4;
            } else if (dir[answer].equals("L")) {
                dIdx = (dIdx + 3) % 4;
            }

        }
    }

}
