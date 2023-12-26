package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCDSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int[] nums = new int[m];
                for (int j = 0; j < m; j++) {
                    nums[j] = Integer.parseInt(st.nextToken());
                }
                sb.append(solve(nums)).append("\n");
            }
        System.out.println(sb);
    }

    private static long solve(final int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                result += calculateGCD(nums[i], nums[j]);
            }
        }
        return result;
    }

    private static int calculateGCD(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }

}
