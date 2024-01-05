package inflearn.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {

    int num1;
    int num2;
    int cost;

    public Edge(final int num1, final int num2, final int cost) {
        this.num1 = num1;
        this.num2 = num2;
        this.cost = cost;
    }

    @Override
    public int compareTo(final Edge o) {
        return cost - o.cost;
    }
}

public class WonderLandUF {

    static int[] unf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        unf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            unf[i] = i;
        }
        int answer = 0;

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(num1, num2, cost));
        }

        Collections.sort(edges);

        for (Edge e : edges) {
            int n1 = find(e.num1);
            int n2 = find(e.num2);

            if (n1 != n2) {
                answer += e.cost;
                union(n1, n2);
            }
        }

        System.out.println(answer);
    }

    private static void union(final int num1, final int num2) {
        int n1 = find(num1);
        int n2 = find(num2);
        if (n1 != n2) {
            unf[n1] = n2;
        }
    }

    private static int find(final int num) {
        if (num == unf[num]) {
            return num;
        }
        return unf[num] = find(unf[num]);
    }

}
