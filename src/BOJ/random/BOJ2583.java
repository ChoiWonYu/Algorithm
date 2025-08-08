package BOJ.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ2583 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();
        boolean[][] board = new boolean[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int c1 = sc.nextInt();
            int r1 = sc.nextInt();
            int c2 = sc.nextInt();
            int r2 = sc.nextInt();
            for (int j = r1; j < r2; j++) {
                for (int q = c1; q < c2; q++) {
                    board[j][q] = true;
                }
            }
        }

        int cnt = 0;
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!board[i][j] && !visited[i][j]) {
                    cnt++;
                    answer.add(bfs(board, visited, i, j));
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    static int bfs(boolean[][] board, boolean[][] visited, int r, int c) {
        Deque<int[]> d = new LinkedList<>();
        int answer = 1;
        d.add(new int[]{r, c});
        visited[r][c] = true;
        while (!d.isEmpty()) {
            int[] cur = d.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur[0] + dr[k];
                int nc = cur[1] + dc[k];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || board[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                d.add(new int[]{nr, nc});
                answer++;
            }
        }
        return answer;
    }
}
