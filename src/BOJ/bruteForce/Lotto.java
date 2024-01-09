package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class Lotto {

    static int n;
    static int[] nums, target;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                return;
            }

            nums = new int[n];
            target = new int[6];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println();
        }
    }

    private static void dfs(final int index, final int depth) {

        if (depth == 6) {
            StringBuilder sb = new StringBuilder();
            for (int n : target) {
                sb.append(n).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = index; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            target[depth] = nums[i];
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

}
