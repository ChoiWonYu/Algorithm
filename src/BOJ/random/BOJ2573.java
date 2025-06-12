package BOJ.random;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ2573 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        while (isConnected(arr)) {
            if (!remain(arr)) {
                answer = 0;
                break;
            }
            answer++;
            int[][] newArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (arr[i][j] != 0) {
                        reduce(newArr, arr, i, j);
                    }
                }
            }
            arr = newArr;
        }
        System.out.println(answer);
    }

    private static boolean remain(final int[][] arr) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void reduce(final int[][] newArr, final int[][] arr, final int r, final int c) {
        int minus = 0;
        for (int i = 0; i < dr.length; i++) {
            int x = r + dr[i];
            int y = c + dc[i];
            if (arr[x][y] == 0) {
                minus++;
            }
        }
        newArr[r][c] = Math.max(arr[r][c] - minus, 0);
    }

    private static boolean isConnected(final int[][] arr) {
        boolean flag = false;
        boolean[][] visited = new boolean[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    if (flag) {
                        return false;
                    }
                    bfs(arr, visited, i, j);
                    flag = true;
                }
            }
        }
        return true;
    }

    private static void bfs(final int[][] arr, final boolean[][] visited, final int r,
        final int c) {
        Deque<int[]> d = new LinkedList<>();
        d.addLast(new int[]{r, c});
        visited[r][c] = true;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.pollFirst();
                for (int j = 0; j < dr.length; j++) {
                    int nextR = cur[0] + dr[j];
                    int nextC = cur[1] + dc[j];
                    if (visited[nextR][nextC] || arr[nextR][nextC] == 0) {
                        continue;
                    }
                    visited[nextR][nextC] = true;
                    d.addLast(new int[]{nextR, nextC});
                }
            }
        }
    }
}
