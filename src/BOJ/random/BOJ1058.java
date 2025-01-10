package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BOJ1058 {

    public static final int LIMIT = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char flag = input.charAt(j);
                if (flag == 'Y') {
                    graph.get(i).add(j + 1);
                }
            }
        }

        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> d = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            d.add(i);
            Arrays.fill(visited, false);
            visited[i] = true;
            int depth = 0;
            int count = 0;
            while (!d.isEmpty() && depth < LIMIT) {
                int len = d.size();
                for (int j = 0; j < len; j++) {
                    int cur = d.pollFirst();
                    for (int friend : graph.get(cur)) {
                        if (visited[friend]) {
                            continue;
                        }
                        visited[friend] = true;
                        count++;
                        d.addLast(friend);
                    }
                }
                depth++;
            }
            d.clear();
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
