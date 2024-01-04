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

public class Dijkstra {

    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            List<Edge> startList = graph.get(start - 1);
            startList.add(new Edge(end, cost));
        }

        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(1, 0));
        dis[1] = 0;

        while (!q.isEmpty()) {
            Edge tmp = q.poll();
            int curStart = tmp.edge;

            if (dis[curStart] < tmp.cost) {
                continue;
            }

            List<Edge> curEdges = graph.get(curStart - 1);
            for (Edge e : curEdges) {
                if (dis[e.edge] > dis[curStart] + e.cost) {
                    dis[e.edge] = dis[curStart] + e.cost;
                    q.offer(e);
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            sb.append(i).append(" : ");
            if (dis[i] == Integer.MAX_VALUE) {
                sb.append("impossible\n");
                continue;
            }
            sb.append(dis[i]).append("\n");
        }

        System.out.println(sb);
    }

}
