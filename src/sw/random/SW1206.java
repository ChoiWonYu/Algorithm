package sw.random;

import java.io.IOException;
import java.util.Scanner;

public class SW1206 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] height;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }
            int answer = 0;
            for (int i = 2; i < n - 2; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i - 2; j <= i + 2; j++) {
                    if (j == i) {
                        continue;
                    }
                    min = Math.min(min, height[i] - height[j]);
                }
                if (min >= 0) {
                    answer += min;
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
