package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ7569 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[] dh = new int[]{1, -1, 0, 0, 0, 0};
        int[] dr = new int[]{0, 0, 1, -1, 0, 0};
        int[] dc = new int[]{0, 0, 0, 0, 1, -1};
        int[][][] tomato = new int[h][n][m];
        Deque<int[]> deque = new LinkedList<>();
        int zeroCnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = sc.nextInt();
                    if (tomato[i][j][k] == 1) {
                        deque.addLast(new int[]{i, j, k});
                    } else if(tomato[i][j][k] == 0) {
                        zeroCnt++;
                    }
                }
            }
        }

        int day = 0;
        while (!deque.isEmpty()) {
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                int[] cur = deque.pollFirst();
                for (int j = 0; j < dr.length; j++) {
                    int nextH = cur[0] + dh[j];
                    int nextR = cur[1] + dr[j];
                    int nextC = cur[2] + dc[j];
                    if (nextH >= 0 && nextH < h && nextR >= 0 && nextR < n && nextC >= 0
                        && nextC < m && tomato[nextH][nextR][nextC] == 0) {
                        tomato[nextH][nextR][nextC] = 1;
                        zeroCnt--;
                        deque.addLast(new int[]{nextH, nextR, nextC});
                    }
                }
            }
            day++;
        }

        int answer = zeroCnt == 0 ? day - 1 : -1;
        System.out.println(answer);
    }
}
