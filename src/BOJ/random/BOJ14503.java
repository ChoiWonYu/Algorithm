package BOJ.random;

import java.util.Scanner;

public class BOJ14503 {

    static int[][] map, dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int n, m, curDir, answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        int curR = sc.nextInt();
        int curC = sc.nextInt();
        curDir = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            if (map[curR][curC] == 0) {
                map[curR][curC] = 2;
                answer++;
            }
            int nextR, nextC;
            for (int i = 1; i <= 4; i++) {
                curDir = (curDir - 1 + 4) % 4;
                nextR = curR + dir[curDir][0];
                nextC = curC + dir[curDir][1];
                if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && map[nextR][nextC] == 0) {
                    curR = nextR;
                    curC = nextC;
                    break;
                }
            }
            if (map[curR][curC] == 0) {
                continue;
            }
            nextR = curR - dir[curDir][0];
            nextC = curC - dir[curDir][1];
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m || map[nextR][nextC] == 1) {
                break;
            } else {
                curR = nextR;
                curC = nextC;
            }
        }
        System.out.println(answer);
        sc.close();
    }

    private static boolean canGo(final int curR, final int curC) {
        for (int i = 0; i < dir.length; i++) {
            int nextR = curR + dir[i][0];
            int nextC = curC + dir[i][1];
            if (nextR >= 0 && nextR < n && nextC >= 0 && nextC < m && map[nextR][nextC] == 0) {
                return true;
            }
        }
        return false;
    }
}
