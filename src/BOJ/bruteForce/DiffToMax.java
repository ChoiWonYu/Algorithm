package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class DiffToMax {

    static int[] nums, target;
    static boolean[] visited;
    static int n, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        visited = new boolean[n];
        target = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(final int depth) {
        if (depth == n) {
            max = Math.max(max, calculate(target));
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

    private static int calculate(final int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        return sum;
    }

}
