package sw.random;

import java.util.Scanner;

public class SW2817 {

    static int n, k, answer;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            k = sc.nextInt();
            answer = 0;
            int[] nums = new int[n];
            int[] cur = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            dfs(nums, cur, 0, -1);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void dfs(int[] nums, int[] cur, int idx, int prev) {
        int sum = 0;
        for (int i = 0; i < idx; i++) {
            sum += cur[i];
        }
        if (sum >= k || idx == n) {
            if (sum == k) {
                answer++;
            }
            return;
        }

        for (int i = prev + 1; i < n; i++) {
            cur[idx] = nums[i];
            dfs(nums, cur, idx + 1, i);
        }
    }
}
