package BOJ.random;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ2636 {

    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Deque<int[]> d = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (char) (sc.nextInt() + '0');
            }
        }

        visited[0][0] = true;
        dfs(0, 0);
        int prevCnt = 0;
        int time = 0;
        while (!d.isEmpty()) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], false);
            }
            visited[0][0] = true;
            dfs(0, 0);
            prevCnt = d.size();
            for (int i = 0; i < prevCnt; i++) {
                int[] cur = d.poll();
                for (int j = 0; j < dr.length; j++) {
                    int nextR = cur[0] + dr[j];
                    int nextC = cur[1] + dc[j];
                    if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m
                        && arr[nextR][nextC] == '1') {
                        arr[nextR][nextC] = 'c';
                        d.add(new int[]{nextR, nextC});
                    }
                }
                arr[cur[0]][cur[1]] = '0';
            }
            time++;
        }
        System.out.println(time);
        System.out.println(prevCnt);
    }

    private static void dfs(final int r, final int c) {
        for (int i = 0; i < dr.length; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && !visited[nextR][nextC]) {
                if (arr[nextR][nextC] == '1') {
                    arr[nextR][nextC] = 'c';
                    d.add(new int[]{nextR, nextC});
                }
                if (arr[nextR][nextC] == '0') {
                    visited[nextR][nextC] = true;
                    dfs(nextR, nextC);
                }

            }
        }
    }

}
