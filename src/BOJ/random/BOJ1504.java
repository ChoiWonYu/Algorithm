package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1504 {

    static List<List<int[]>> graph = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int e = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            graph.get(start).add(new int[]{end, price});
            graph.get(end).add(new int[]{start, price});
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int startToV1 = calculate(1, v1);
        int v1ToV2 = calculate(v1, v2);
        int v2ToN = calculate(v2, n);

        int answer1 =
            startToV1 == -1 || v1ToV2 == -1 || v2ToN == -1 ? -1 : startToV1 + v1ToV2 + v2ToN;

        int startToV2 = calculate(1, v2);
        int v2ToV1 = calculate(v2, v1);
        int v1ToN = calculate(v1, n);

        int answer2 =
            startToV2 == -1 || v2ToV1 == -1 || v1ToN == -1 ? -1 : startToV2 + v2ToV1 + v1ToN;

        int answer = answer1 == -1 && answer2 == -1 ? -1 : Math.min(answer1, answer2);
        System.out.println(answer);
    }

    public static int calculate(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int price = poll[1];
            for (int[] edge : graph.get(cur)) {
                int next = edge[0];
                int nextPrice = price + edge[1];
                if (dp[next] > nextPrice) {
                    dp[next] = nextPrice;
                    pq.offer(new int[]{next, nextPrice});
                }
            }
        }
        return dp[end] == Integer.MAX_VALUE ? -1 : dp[end];
    }

}
