package BOJ.bruteForce;

import java.lang.*;
import java.io.*;

public class Bomboni {

    static int[] xDir = new int[]{0, 0, 1, -1};
    static int[] yDir = new int[]{-1, 1, 0, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[][] c = new char[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            c[i] = input.toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, getMaxRowSum(c[i]));
            answer = Math.max(answer, getMaxColSum(c, i));
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + xDir[k];
                    int y = j + yDir[k];
                    if (x < 0 || x >= n || y < 0 || y >= n || c[i][j] == c[x][y]) {
                        continue;
                    }

                    changeValue(c, x, y, i, j);
                    int rowSum = getMaxRowSum(c[i]);
                    int colSum = getMaxColSum(c, j);
                    answer = Math.max(answer, Math.max(rowSum, colSum));
                    if (answer == n) {
                        System.out.println(n);
                        return;
                    }
                    changeValue(c, x, y, i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void changeValue(final char[][] c, final int x, final int y, final int i,
        final int j) {
        char tmp = c[x][y];
        c[x][y] = c[i][j];
        c[i][j] = tmp;
    }

    private static int getMaxColSum(final char[][] c, final int col) {
        char cur = c[0][col];
        int result = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            if (c[i][col] != cur) {
                result = Math.max(result, sum);
                sum = 1;
                cur = c[i][col];
                continue;
            }
            sum++;
        }

        return Math.max(result, sum);
    }

    public static int getMaxRowSum(final char[] c) {
        char cur = c[0];
        int result = 1;
        int sum = 1;
        for (int i = 1; i < n; i++) {
            if (c[i] != cur) {
                result = Math.max(result, sum);
                sum = 1;
                cur = c[i];
                continue;
            }
            sum++;
        }
        return Math.max(result, sum);
    }


}
