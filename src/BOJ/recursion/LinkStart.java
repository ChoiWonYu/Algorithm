package BOJ.recursion;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class LinkStart {

    static int n;
    static int[][] graph;
    static List<Integer> opposite, cur;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        opposite = new ArrayList<>();
        cur = new ArrayList<>();

        for (int i = 0; i <= n / 2; i++) {
            opposite.add(0);
            cur.add(0);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0);

        System.out.println(result);
    }

    private static void recursion(final int depth, final int index) {

        if (depth > n / 2) {
            return;
        }

        for (int t = index; t < n; t++) {
            cur.set(depth, t);
            if (depth <= n / 2) {
                opposite = IntStream.range(0, n)
                    .filter(num -> IntStream.range(0, depth + 1)
                        .noneMatch(idx -> num == cur.get(idx)))
                    .boxed()
                    .collect(Collectors.toList());

                int oppositeSum = 0;
                int sum = 0;
                for (int i = 0; i < opposite.size(); i++) {
                    for (int j = 0; j < opposite.size(); j++) {
                        oppositeSum += graph[opposite.get(i)][opposite.get(j)];
                    }
                }

                for (int i = 0; i <= depth; i++) {
                    for (int j = 0; j <= depth; j++) {
                        sum += graph[cur.get(i)][cur.get(j)];
                    }
                }
                result = Math.min(result, Math.abs(oppositeSum - sum));
            }
            recursion(depth + 1, t + 1);
        }

    }

}
