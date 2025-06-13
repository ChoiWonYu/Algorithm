package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ17144 {

    static int[] drt = {0, -1, 0, 1};
    static int[] drd = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int r, c, t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        t = sc.nextInt();
        Deque<int[]> d = new LinkedList<>();
        int[][] arr = new int[r][c];
        int[] top = new int[5];
        int[] bottom = new int[5];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == -1) {
                    if (d.isEmpty()) {
                        top = new int[]{0, i, j, -1, 0};
                        d.addLast(top);
                    } else {
                        bottom = new int[]{1, i, j, -1, 0};
                        d.addLast(bottom);
                    }
                }
            }
        }

        for (int tc = 0; tc < t; tc++) {
            int[][] addArr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] == -1 || arr[i][j] == 0) {
                        continue;
                    }
                    int volume = arr[i][j] / 5;
                    int cnt = 0;
                    for (int k = 0; k < dc.length; k++) {
                        int nextR = i + drt[k];
                        int nextC = j + dc[k];
                        if (nextR >= 0 && nextR < r && nextC >= 0 && nextC < c
                            && arr[nextR][nextC] != -1) {
                            cnt++;
                            addArr[nextR][nextC] += volume;
                        }
                    }
                    arr[i][j] = Math.max(0, arr[i][j] - cnt * volume);
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (arr[i][j] != -1) {
                        arr[i][j] += addArr[i][j];
                    }
                }
            }

            while (!d.isEmpty()) {
                int len = d.size();
                for (int i = 0; i < len; i++) {
                    int[] curArr = d.pollFirst();
                    int curStart = curArr[0];
                    int curR = curArr[1];
                    int curC = curArr[2];
                    int curV = curArr[3];
                    int dirIdx = curArr[4];
                    int nextR = curStart == 0 ? curR + drt[dirIdx] : curR + drd[dirIdx];
                    int nextC = curC + dc[dirIdx];
                    if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) {
                        dirIdx++;
                        nextR = curStart == 0 ? curR + drt[dirIdx] : curR + drd[dirIdx];
                        nextC = curC + dc[dirIdx];
                    }
                    int nextV = arr[nextR][nextC];
                    if (nextV != -1) {
                        arr[nextR][nextC] = curV == -1 ? 0 : curV;
                        d.addLast(new int[]{curStart, nextR, nextC, nextV, dirIdx});
                    }
                }
            }
            d.addLast(top);
            d.addLast(bottom);
        }
        long answer = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != -1) {
                    answer += arr[i][j];
                }
            }
        }
        System.out.println(answer);
    }

}
