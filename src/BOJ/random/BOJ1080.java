package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {

    static int[][] a, b;
    public static int n, m, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n][m];
        b = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '0') {
                    a[i][j] = 0;
                } else {
                    a[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '0') {
                    b[i][j] = 0;
                } else {
                    b[i][j] = 1;
                }
            }
        }

        dfs(a, 0, -1, -1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void dfs(int[][] arr, int cnt, int prevX, int prevY) {
        if (answer != Integer.MAX_VALUE) {
            return;
        }
        if (isSame(arr)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (i == prevX && j == prevY) {
                    continue;
                }
                if (arr[i][j] != b[i][j]) {
                    change33(arr, i, j);
                    dfs(arr, cnt + 1, i, j);
                }
            }
        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (arr[i][j] != b[i][j]) {
//                    arr[i][j] = arr[i][j] == 0 ? 1 : 0;
//                    dfs(arr, cnt + 1);
//                    arr[i][j] = arr[i][j] == 0 ? 1 : 0;
//                }
//            }
//        }
    }

    private static void change33(final int[][] arr, final int startX, final int startY) {
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                arr[i][j] = arr[i][j] == 0 ? 1 : 0;
            }
        }
    }

    private static boolean isSame(final int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
