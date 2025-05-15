package sw.random;

import java.util.Scanner;

public class SW5215 {

    static int limit, n, answer;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= t; test_case++) {
            n = sc.nextInt();
            limit = sc.nextInt();
            arr = new int[n][2];
            answer = 0;
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            dfs(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(final int curScore, final int curC, final int curIdx) {
        if (curC > limit) {
            return;
        }
        answer = Math.max(answer, curScore);
        if(curIdx == n) {
            return;
        }
        dfs(curScore + arr[curIdx][0], curC + arr[curIdx][1], curIdx + 1);
        dfs(curScore, curC, curIdx + 1);
    }

}
