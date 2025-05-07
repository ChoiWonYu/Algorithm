package sw.random;

import java.io.IOException;
import java.util.Scanner;

public class SW1859 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int[] price = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = sc.nextInt();
            }

            long max = Long.MIN_VALUE;
            long result = 0;
            long cnt = 0;
            long cost = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (max < price[i]) {
                    result += (max * cnt - cost);
                    max = price[i];
                    cnt = 0;
                    cost = 0;
                } else {
                    cnt++;
                    cost += price[i];
                }
            }
            result += (max * cnt - cost);
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
