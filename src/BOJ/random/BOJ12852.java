package BOJ.random;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ12852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 1; i--) {
            int n1 = i + 1;
            int n2 = i * 2;
            int n3 = i * 3;

            if (n1 <= n) {
                dp[i] = Math.min(dp[i], dp[i + 1] + 1);
            }
            if (n2 <= n) {
                dp[i] = Math.min(dp[i], dp[i * 2] + 1);
            }
            if (n3 <= n) {
                dp[i] = Math.min(dp[i], dp[i * 3] + 1);
            }
        }

        System.out.println(dp[1]);
        Deque<Integer> route = new LinkedList<>();
        route.add(1);
        int cur = 1;
        for (int i = 1; i <= dp[1]; i++) {
            if (cur + 1 <= n && dp[cur + 1] == dp[1] - i) {
                route.addFirst(cur + 1);
                cur = cur + 1;
                continue;
            }
            if (cur * 2 <= n && dp[cur * 2] == dp[1] - i) {
                route.addFirst(cur * 2);
                cur = cur * 2;
                continue;
            }
            if (cur * 3 <= n && dp[cur * 3] == dp[1] - i) {
                route.addFirst(cur * 3);
                cur = cur * 3;
            }
        }

        while(!route.isEmpty()) {
            System.out.print(route.pollFirst() + " ");
        }
    }

}
