package BOJ.recursion;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class StartLink {

    static int[] nums;
    static List<Integer> cur, opposite;
    static int[][] graph;
    static boolean[] visited;
    static int n, result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        nums = new int[n];
        cur = new ArrayList<>();
        opposite = new ArrayList<>();
        for (int i = 0; i < n / 2; i++) {
            cur.add(i);
            opposite.add(i);
        }
        visited = new boolean[n];

        recursion(0, 0);

        System.out.println(result);
    }

    private static void recursion(final int depth, final int index) {
        if (depth == n / 2) {
            opposite = IntStream.range(0, n)
                .filter(num -> !cur.contains(num))
                .boxed()
                .collect(Collectors.toList());

            int sum = 0;
            int oppositeSum = 0;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    sum += graph[cur.get(i)][cur.get(j)];
                    oppositeSum += graph[opposite.get(i)][opposite.get(j)];
                }
            }

            result = Math.min(Math.abs(sum - oppositeSum), result);
            return;
        }

        for (int i = index; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur.set(depth, i);
            recursion(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}
