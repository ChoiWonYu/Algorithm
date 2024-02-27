package BOJ.recursion;

import java.io.*;
import java.util.*;

public class Sum1 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        int[] cur = new int[n];
        boolean[] visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(nums, cur, visited, 0, 0, s);

        System.out.println(cnt);
    }

    private static void dfs(int[] nums, int[] cur, boolean[] visited, int depth, int idx,
        int target) {
        if (depth > 0) {
            int sum = 0;
            for (int i = 0; i < depth; i++) {
                sum += cur[i];
            }
            if (sum == target) {
                cnt++;
            }
        }

        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur[depth] = nums[i];
            dfs(nums, cur, visited, depth + 1, i, target);
            visited[i] = false;
        }
    }

}
