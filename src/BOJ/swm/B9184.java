package BOJ.swm;

import java.io.*;
import java.util.*;

public class B9184 {

    static int[][][] memo = new int[51][51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a, b, c;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(").append(a).append(", ").append(b).append(", ")
                .append(c).append(") = ").append(recursion(a, b, c)).append("\n");

        }
        System.out.println(sb);
    }

    private static int recursion(final int a, final int b, final int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (memo[a][b][c] != 0) {
            return memo[a][b][c];
        }

        if (a > 20 || b > 20 || c > 20) {
            memo[a][b][c] = recursion(20, 20, 20);
            return memo[a][b][c];
        }

        if (a < b && b < c) {
            memo[a][b][c] =
                recursion(a, b, c - 1) + recursion(a, b - 1, c - 1) - recursion(a, b - 1, c);
            return memo[a][b][c];
        }

        memo[a][b][c] =
            recursion(a - 1, b, c) + recursion(a - 1, b - 1, c) + recursion(a - 1, b, c - 1)
                - recursion(a - 1, b - 1, c - 1);
        return memo[a][b][c];
    }

}
