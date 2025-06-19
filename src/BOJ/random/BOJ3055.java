package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ3055 {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] arr = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        Deque<int[]> route = new LinkedList<>();
        Deque<int[]> water = new LinkedList<>();

        boolean[][] isWater = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                char cur = input.charAt(j);
                arr[i][j] = cur;
                if (cur == 'S') {
                    route.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (cur == '*') {
                    water.add(new int[]{i, j});
                    isWater[i][j] = true;
                }
            }
        }

        boolean flag = false;
        int answer = 0;

        while (!flag && !route.isEmpty()) {
            // 물 확장
            int wLen = water.size();
            for (int i = 0; i < wLen; i++) {
                int[] cur = water.pollFirst();
                for (int j = 0; j < dr.length; j++) {
                    int nr = cur[0] + dr[j];
                    int nc = cur[1] + dc[j];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m || arr[nr][nc] == 'X'
                        || arr[nr][nc] == 'D' || isWater[nr][nc]) {
                        continue;
                    }
                    isWater[nr][nc] = true;
                    water.add(new int[]{nr, nc});
                }
            }

            // 이동
            int len = route.size();
            for (int i = 0; i < len; i++) {
                int[] cur = route.pollFirst();
                for (int j = 0; j < dr.length; j++) {
                    int nr = cur[0] + dr[j];
                    int nc = cur[1] + dc[j];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m || isWater[nr][nc]
                        || arr[nr][nc] == 'X' || visited[nr][nc]) {
                        continue;
                    }

                    if (arr[nr][nc] == 'D') {
                        i = len;
                        flag = true;
                        break;
                    }

                    visited[nr][nc] = true;
                    route.add(new int[]{nr, nc});
                }
            }
            answer++;
        }

        System.out.println(flag ? answer : "KAKTUS");
    }
}
