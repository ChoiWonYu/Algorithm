package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11404 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            graph.get(start).add(new int[]{end, price});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        long[] dp = new long[n + 1];

        for (int start = 1; start <= n; start++) {
            Arrays.fill(dp, Long.MAX_VALUE);
            pq.clear();
            dp[start] = 0;
            pq.add(new int[]{start, 0});
            while (!pq.isEmpty()) {
                int[] curArr = pq.poll();
                int cur = curArr[0];
                int price = curArr[1];
                for(int[] edge : graph.get(cur)) {
                    int next = edge[0];
                    int nextPrice = edge[1] + price;
                    if(dp[next] > nextPrice) {
                        dp[next] = nextPrice;
                        pq.add(new int[]{next, nextPrice});
                    };
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.print(dp[i] == Long.MAX_VALUE ? 0 + " " : dp[i] + " ");
            }
            System.out.println();
        }
    }

}
