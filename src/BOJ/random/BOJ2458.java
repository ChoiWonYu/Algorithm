package BOJ.random;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ2458 {

    static List<List<Integer>> small = new ArrayList<>();
    static List<List<Integer>> big = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            small.add(new ArrayList<>());
            big.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int l = sc.nextInt();
            small.get(l).add(s);
            big.get(s).add(l);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int s = bfs(small, i);
            int b = bfs(big, i);
            if (s + b == n - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int bfs(List<List<Integer>> graph, int num) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> d = new LinkedList<>();
        d.addLast(num);
        visited[num] = true;
        int cnt = 0;
        while (!d.isEmpty()) {
            int size = d.size();
            for (int i = 0; i < size; i++) {
                int cur = d.pollFirst();
                for (int j : graph.get(cur)) {
                    if (!visited[j]) {
                        d.addLast(j);
                        visited[j] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}
