package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class Circle {

    static int[][] graph;
    static int[] nums, target;
    static boolean[] visited;
    static int n;
    static long minCost = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i] = i;
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        target = new int[n];
        visited = new boolean[n];

        dfs(0);

        System.out.println(minCost);
    }

    private static void dfs(final int depth) {
        if (depth == n) {
            minCost = Math.min(minCost, calculateCost(target));
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            target[depth] = nums[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }

    private static long calculateCost(final int[] nums) {
        int cost = 0;
        for (int i = 0; i < n - 1; i++) {
            if (graph[nums[i]][nums[i + 1]] == 0) {
                return Long.MAX_VALUE;
            }
            cost += graph[nums[i]][nums[i + 1]];
        }
        if (graph[nums[n - 1]][nums[0]] == 0) {
            return Long.MAX_VALUE;
        }
        cost += graph[nums[n - 1]][nums[0]];
        return cost;
    }

}
