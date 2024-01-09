package BOJ.bruteForce;

import java.io.*;

public class AllPermutation {

    private static int n;
    private static int[] nums, target;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        target = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        dfs(0);
    }

    private static void dfs(final int depth) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i : target) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            target[depth] = nums[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}
