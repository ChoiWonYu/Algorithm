package BOJ.recursion;

import java.io.*;
import java.util.*;

public class Sum2 {

    static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        int[] cur = new int[n];
        boolean[] visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums, cur, visited, 0, 0);

        int result = 1;
        while (s.contains(result)) {
            result++;
        }
        System.out.println(result);
    }

    private static void dfs(int[] nums, int[] cur, boolean[] visited, int depth, int idx) {
        if (depth > 0) {
            int sum = 0;
            for (int i = 0; i < depth; i++) {
                sum += cur[i];
            }
            s.add(sum);
        }

        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur[depth] = nums[i];
            dfs(nums, cur, visited, depth + 1, i);
            visited[i] = false;
        }
    }

}
