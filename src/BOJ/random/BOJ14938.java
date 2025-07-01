package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ14938 {

    static List<List<int[]>> graph;
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int r = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, getItemCnt(arr, i));
        }

        System.out.println(answer);
    }

    public static long getItemCnt(int[] arr, int v) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        pq.offer(new int[]{v, 0});
        dp[v] = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int cur = poll[0];
            int curCost = poll[1];
            for (int[] nextArr : graph.get(cur)) {
                int next = nextArr[0];
                int nextCost = nextArr[1] + curCost;
                if (nextCost > dp[next]) {
                    continue;
                }
                dp[next] = nextCost;
                pq.offer(new int[]{next, nextCost});
            }
        }

        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (dp[i] <= m) {
                result += arr[i];
            }
        }
        return result;
    }
}
