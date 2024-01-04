package inflearn.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int edge;
    int cost;

    public Edge(final int edge, final int cost) {
        this.edge = edge;
        this.cost = cost;
    }

    @Override
    public int compareTo(final Edge o) {
        return cost - o.cost;
    }
}

public class WonderLand {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start - 1).add(new Edge(end, cost));
            graph.get(end - 1).add(new Edge(start, cost));
        }
        int result = 0;

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(1, 0));

        while (!q.isEmpty()) {
            Edge curEdge = q.poll();

            int curLoc = curEdge.edge;
            int curCost = curEdge.cost;

            if (dis[curLoc] < curCost) {
                continue;
            }
            visited[curLoc] = true;
            result += curEdge.cost;
            for (Edge e : graph.get(curLoc - 1)) {
                if (!visited[e.edge] && e.cost < dis[e.edge]) {
                    dis[e.edge] = e.cost;
                    q.offer(e);
                }
            }

        }
        System.out.println(result);
    }

}
