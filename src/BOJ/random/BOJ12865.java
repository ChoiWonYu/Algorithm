package BOJ.random;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int w = sc.nextInt();

        long[] dp = new long[w + 1];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int cur = arr[i][0];
            for (int j = w; j >= cur; j--) {
                dp[j] = Math.max(dp[j], dp[j - cur] + arr[i][1]);
            }
        }
        long max = Long.MIN_VALUE;
        for (int i = 1; i <= w; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
