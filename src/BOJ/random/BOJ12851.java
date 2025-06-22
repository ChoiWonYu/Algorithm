package BOJ.random;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BOJ12851 {

    static int answer, k;
    static int[] dp;
    static Deque<Integer> d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        answer = 0;
        d = new ArrayDeque<>();
        d.add(n);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.poll();
                int plus = cur + 1;
                int minus = cur - 1;
                int mul = cur * 2;
                process(plus, cur);
                process(mul, cur);
                process(minus, cur);
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]);
        System.out.println(answer);
    }

    public static void process(int cur, int prev) {
        if (cur < 0 || cur > 100000 || dp[cur] < dp[prev] + 1) {
            return;
        }
        if (cur == k) {
            if (dp[prev] + 1 < dp[cur]) {
                dp[cur] = dp[prev] + 1;
                answer = 1;
            } else {
                answer++;
            }
            return;
        }
        dp[cur] = dp[prev] + 1;
        d.add(cur);
    }
}
