package BOJ.random;

import java.util.Scanner;

public class BOJ10026 {

    static int[][] arr1;
    static int[][] arr2;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited1;
    static boolean[][] visited2;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr1 = new int[n][n];
        arr2 = new int[n][n];
        visited1 = new boolean[n][n];
        visited2 = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                char cur = input.charAt(j);
                arr1[i][j] = cur;
                if (cur == 'G') {
                    cur = 'R';
                }
                arr2[i][j] = cur;
            }
        }

        int answer1 = 0;
        int answer2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited1[i][j]) {
                    answer1++;
                    visited1[i][j] = true;
                    dfs(arr1, visited1, i, j);
                }
                if (!visited2[i][j]) {
                    answer2++;
                    visited2[i][j] = true;
                    dfs(arr2, visited2, i, j);
                }
            }
        }
        System.out.println(answer1 + " " + answer2);
    }

    private static void dfs(final int[][] arr, final boolean[][] visited, final int r,
        final int c) {
        for (int i = 0; i < dr.length; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC]
                && arr[nextR][nextC] == arr[r][c]) {
                visited[nextR][nextC] = true;
                dfs(arr, visited, nextR, nextC);
            }
        }
    }

}
