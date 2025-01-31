package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1325 {

    static int[] hack;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화(신뢰를 받는 컴퓨터에 추가)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

//            graph.get(n2).add(n1);
            graph.get(n1).add(n2);
        }

        hack = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for (int h : hack) {
            max = Math.max(max, h);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (max == hack[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void bfs(int num) {
        Deque<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = true;
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            for (int com : graph.get(cur)) {
                if (visited[com]) {
                    continue;
                }
                visited[com] = true;
                hack[com]++;
                q.addLast(com);
            }
        }
    }

//    public static void dfs(int start, int end) {
//        visited[start][end] = true;
//        for (int next : graph.get(end)) {
//            if (visited[start][next]) {
//                continue;
//            }
//            visited[start][next] = true;
//            hack[start]++;
//            dfs(start, next);
//        }
//    }
}
