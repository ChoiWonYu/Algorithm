package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ11559 {

    static int n = 12;
    static int m = 6;
    static char[][] arr = new char[n][m];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        boolean flag = true;
        int answer = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] != '.' && canBlow(i, j)) {
                        flag = true;
                        blow(i, j);
                    }
                }
            }
            if (flag) {
                answer++;
                down();
            }
        }
        System.out.println(answer);
    }

    private static void down() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j != n - 1 && arr[j][i] != '.' && arr[j + 1][i] == '.') {
                    int r = j + 1;
                    while (r < n && arr[r][i] == '.') {
                        r++;
                    }
                    arr[r - 1][i] = arr[j][i];
                    arr[j][i] = '.';
                }
            }
        }
    }

    private static void blow(final int r, final int c) {
        char curC = arr[r][c];
        arr[r][c] = '.';
        for (int i = 0; i < dr.length; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || arr[nextR][nextC] == '.'
                || arr[nextR][nextC] != curC) {
                continue;
            }
            blow(nextR, nextC);
        }
    }

    public static boolean canBlow(int r, int c) {
        Deque<int[]> d = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        d.add(new int[]{r, c});
        visited[r][c] = true;
        int cnt = 1;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int[] cur = d.poll();
                for (int j = 0; j < dr.length; j++) {
                    int nextR = cur[0] + dr[j];
                    int nextC = cur[1] + dc[j];
                    if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || visited[nextR][nextC]
                        || arr[nextR][nextC] == '.' || arr[nextR][nextC] != arr[cur[0]][cur[1]]) {
                        continue;
                    }
                    d.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                    cnt++;
                    if (cnt >= 4) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
