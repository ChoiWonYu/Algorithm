package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1753 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int n = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        long[] dp = new long[v + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        for (int i = 0; i < e; i++) {
            graph.get(sc.nextInt()).add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.offer(new int[]{n, 0});
        while (!queue.isEmpty()) {
            int[] curArr = queue.poll();
            int next = curArr[0];
            int price = curArr[1];
            if (dp[next] <= price) {
                continue;
            }
            dp[next] = price;
            for (int[] edge : graph.get(next)) {
                queue.offer(new int[]{edge[0], edge[1] + price});
            }
        }

        for (int i = 1; i <= v; i++) {
            System.out.println(dp[i] == Long.MAX_VALUE ? "INF" : dp[i]);
        }
    }
}
