package BOJ.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM5 {

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
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

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
