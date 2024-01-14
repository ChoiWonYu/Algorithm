package BOJ.graph;

import java.io.*;
import java.util.*;

public class HouseNumber {

    static int n;
    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - 48;
            }
        }

        Deque<int[]> d = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        int number = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || graph[i][j] == 0) {
                    continue;
                }
                graph[i][j] = ++number + 1;
                result.add(1);
                int[] cur = new int[]{i, j};
                visited[i][j] = true;
                d.add(cur);
                while (!d.isEmpty()) {
                    int[] target = d.poll();
                    for (int k = 0; k < 4; k++) {
                        if (!isValid(target, dx[k], dy[k])) {
                            continue;
                        }
                        result.set(number, result.get(number) + 1);
                        graph[target[0] + dx[k]][target[1] + dy[k]] = number + 1;
                        visited[target[0] + dx[k]][target[1] + dy[k]] = true;
                        d.add(new int[]{target[0] + dx[k], target[1] + dy[k]});
                    }
                }
            }
        }
        sb.append(result.size()).append("\n");
        result.stream()
            .sorted()
            .forEach(num -> {
                sb.append(num).append("\n");
            });

        System.out.println(sb);
    }

    private static boolean isValid(final int[] location, final int x, final int y) {
        return location[0] + x >= 0 && location[1] + y >= 0 && location[0] + x < n
            && location[1] + y < n
            && !visited[location[0] + x][location[1] + y]
            && graph[location[0] + x][location[1] + y] != 0;
    }

}
