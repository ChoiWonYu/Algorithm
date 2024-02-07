package Programmers.dfsbfs;

import java.util.*;

public class Travel {

    List<String> results = new ArrayList<>();
    String[] cur;
    int limit;
    String[][] t;
    boolean[] visited;

    public String[] solution(String[][] tickets) {

        cur = new String[tickets.length + 1];
        visited = new boolean[tickets.length];
        t = tickets;
        limit = tickets.length;
        for (int i = 0; i < tickets.length; i++) {
            cur[0] = tickets[i][0];
            if (!cur[0].equals("ICN")) {
                continue;
            }
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        Collections.sort(results);

        return results.get(0)
            .split(",");
    }

    public void dfs(int idx, int depth) {

        if (depth == limit) {
            cur[depth] = t[idx][1];
            results.add(String.join(",", cur));
            return;
        }

        String start = t[idx][1];
        cur[depth] = start;
        for (int i = 0; i < limit; i++) {
            if (i == idx || visited[i]) {
                continue;
            }
            if (t[i][0].equals(start)) {
                visited[i] = true;
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }
}
