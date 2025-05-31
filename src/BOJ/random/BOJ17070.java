package BOJ.random;

import java.util.Scanner;

public class BOJ17070 {

    static int n;
    static int[][] arr, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        cnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        cnt[0][0] = 1;
        cnt[0][1] = 1;
        dfs(0, 1, 0);
        System.out.println(cnt[n - 1][n - 1]);
    }

    private static void dfs(final int r, final int c, final int dir) {
        if (dir == 0) {
            moveLeft(r, c);
            moveLeftDown(r, c);
        } else if (dir == 1) {
            moveDown(r, c);
            moveLeftDown(r, c);
        } else {
            moveLeft(r, c);
            moveDown(r, c);
            moveLeftDown(r, c);
        }
    }

    private static void moveDown(final int r, final int c) {
        int nextR, nextC;
        nextR = r + 1;
        nextC = c;
        if (isValid(nextR, nextC)) {
            cnt[nextR][nextC]++;
            dfs(nextR, nextC, 1);
        }
    }

    private static void moveLeftDown(final int r, final int c) {
        int nextR1, nextR2, nextR3, nextC1, nextC2, nextC3;
        nextR1 = r;
        nextR2 = r + 1;
        nextR3 = r + 1;
        nextC1 = c + 1;
        nextC2 = c;
        nextC3 = c + 1;
        if (isValid(nextR1, nextC1) && isValid(nextR2, nextC2) && isValid(nextR3, nextC3)) {
            cnt[nextR3][nextC3]++;
            dfs(nextR3, nextC3, 2);
        }
    }

    private static void moveLeft(final int r, final int c) {
        int nextR, nextC;
        nextR = r;
        nextC = c + 1;
        if (isValid(nextR, nextC)) {
            cnt[nextR][nextC]++;
            dfs(nextR, nextC, 0);
        }
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && arr[r][c] == 0;
    }
}
