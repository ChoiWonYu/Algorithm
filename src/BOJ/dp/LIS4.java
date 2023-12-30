package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class LIS4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int max;
        int answer = 1;
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(dp[i], answer);
        }

        sb.append(answer).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == answer) {
                stack.push(nums[i]);
                answer--;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

}
