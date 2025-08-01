package BOJ.random;

import java.util.Scanner;

public class BOJ1003 {

    static int[] zeroCnt = new int[41];
    static int[] oneCnt = new int[41];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        zeroCnt[0] = 1;
        zeroCnt[1] = 0;
        zeroCnt[40] = dfs0(40);
        oneCnt[1] = 1;
        oneCnt[2] = 1;
        oneCnt[40] = dfs1(40);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            System.out.println(zeroCnt[n] + " " + oneCnt[n]);
        }
    }

    static int dfs0(int n) {
        if (n <= 1 || zeroCnt[n] != 0) {
            return zeroCnt[n];
        }
        return zeroCnt[n] = dfs0(n - 2) + dfs0(n - 1);
    }

    static int dfs1(int n) {
        if (n <= 2 || oneCnt[n] != 0) {
            return oneCnt[n];
        }
        return oneCnt[n] = dfs1(n - 2) + dfs1(n - 1);
    }
}
