package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ18352 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[x] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{x, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int price = poll[1];
            for (int next : graph.get(cur)) {
                if (dp[next] > price + 1) {
                    dp[next] = price + 1;
                    pq.offer(new int[]{next, price + 1});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dp[i] == k) {
                ans.add(i);
            }
        }

        Collections.sort(ans);
        if (ans.isEmpty()) {
            System.out.println(-1);
        } else {
            for (int i : ans) {
                System.out.println(i);
            }
        }
    }

}
