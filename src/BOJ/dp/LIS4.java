package BOJ.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            answers.add(new ArrayList<>());
        }
        int[] dp = new int[n];
        int max = 1;
        int cur;
        dp[0] = 1;
        answers.get(0).add(nums[0]);

        for (int i = 1; i < n; i++) {
            cur = 0;
            answers.get(i).add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && cur < dp[j]) {
                    cur = dp[j];
                    answers.get(i).clear();
                    answers.get(i).addAll(answers.get(j));
                    answers.get(i).add(nums[i]);
                }
            }
            dp[i] = cur + 1;
            max = Math.max(max, dp[i]);
        }

        for (int i = 0; i < n; i++) {
            if (answers.get(i).size() == max) {
                sb.append(max).append("\n");

                for (int j = 0; j < answers.get(i).size(); j++) {
                    sb.append(answers.get(i).get(j)).append(" ");
                }
                break;
            }
        }

        System.out.println(sb);
    }

}
