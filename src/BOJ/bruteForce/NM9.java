package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class NM9 {

    static int[] nums, print;
    static int n, m;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        print = new int[m];

        dfs(0);

        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void dfs(final int depth) {

        if (depth == m) {
            for (int i : print) {
                sb.append(i).append(" ");
            }
            sb = new StringBuilder();
            result.add(sb.toString());
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
