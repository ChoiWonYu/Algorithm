package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            if (f1 == -1) {
                break;
            }

            graph.get(f1).add(f2);
            graph.get(f2).add(f1);
        }

        int[] scores = new int[n + 1];

        for (int member = 1; member <= n; member++) {

            boolean[] visited = new boolean[n + 1];
            visited[member] = true;
            Deque<Integer> d = new LinkedList<>();
            d.add(member);
            int score = 0;
            while (!d.isEmpty()) {
                int len = d.size();
                for (int i = 0; i < len; i++) {
                    int cur = d.pollFirst();
                    for (int f : graph.get(cur)) {
                        if (visited[f]) {
                            continue;
                        }
                        d.add(f);
                        visited[f] = true;
                    }
                }
                score++;
            }
            scores[member] = score - 1;
        }

        StringBuilder sb = new StringBuilder();
        int minScore = Integer.MAX_VALUE;
        int minCnt = 0;
        for (int i = 1; i <= n; i++) {
            if (minScore >= scores[i]) {
                if (minScore == scores[i]) {
                    minCnt++;
                } else {
                    minScore = scores[i];
                    minCnt = 1;
                }
            }
        }
        sb.append(minScore).append(" ").append(minCnt).append("\n");
        for (int i = 1; i <= n; i++) {
            if (scores[i] == minScore) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

}
