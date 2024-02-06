package Programmers.dfsbfs;

import java.util.*;

public class Network {

    boolean[] visited;
    List<List<Integer>> link;

    public int solution(int n, int[][] computers) {
        link = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            link.add(new ArrayList<>());
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 0) {
                    continue;
                }
                if (i == j) {
                    continue;
                }
                link.get(i).add(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(i);
            answer++;
        }
        return answer;
    }

    public void dfs(int idx) {
        List<Integer> linkInfo = link.get(idx);
        for (int n : linkInfo) {
            if (visited[n]) {
                continue;
            }
            visited[n] = true;
            dfs(n);
        }
    }

}
