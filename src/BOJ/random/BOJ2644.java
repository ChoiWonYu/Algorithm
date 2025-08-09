package BOJ.random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ2644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        boolean[] visited = new boolean[n + 1];

        Deque<Integer> d = new LinkedList<>();
        d.add(n1);
        visited[n1] = true;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int g1 = sc.nextInt();
            int g2 = sc.nextInt();
            graph.get(g1).add(g2);
            graph.get(g2).add(g1);
        }

        int answer = 1;
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                int cur = d.pollFirst();
                for (int next : graph.get(cur)) {
                    if (next == n2) {
                        System.out.println(answer);
                        return;
                    }
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    d.addLast(next);
                }
            }
            answer++;
        }

        System.out.println(-1);
    }

}
