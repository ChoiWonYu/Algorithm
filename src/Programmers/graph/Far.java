package Programmers.graph;

import java.util.*;

public class Far {

    public int solution(int n, int[][] edge) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        boolean[] visited = new boolean[n + 1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int p1 = edge[i][0];
            int p2 = edge[i][1];

            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        Deque<Integer> d = new LinkedList<>();
        dis[1] = 0;
        d.add(1);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.poll();
                for (int pt : graph.get(cur)) {
                    if (visited[pt]) {
                        continue;
                    }
                    visited[pt] = true;
                    dis[pt] = Math.min(dis[pt], dis[cur] + 1);
                    d.add(pt);
                }
            }
        }

        int max = (int) Arrays.stream(dis)
            .max()
            .getAsInt();

        return (int) Arrays.stream(dis)
            .filter(num -> num == max)
            .count();
    }

}
