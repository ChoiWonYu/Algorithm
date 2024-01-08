package BOJ.bruteForce;

import java.util.*;
import java.io.*;

public class NM1 {

    static int[] nums, print;
    static boolean[] visited;
    static int n, m;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        print = new int[m];
        visited = new boolean[n];

        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(final int depth) {

        if (depth == m) {
            for (int i : print) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            print[depth] = nums[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}
