package sw.random;

import java.util.Scanner;

public class SW1209 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        int[][] arr;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            sc.nextInt();
            arr = new int[100][100];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 행의 합
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += arr[i][j];
                }
                max = Math.max(max, sum);
            }

            // 열의 합
            for (int i = 0; i < 100; i++) {
                int sum = 0;
                for (int j = 0; j < 100; j++) {
                    sum += arr[j][i];
                }
                max = Math.max(max, sum);
            }

            // 대각선의 합
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < 100; i++) {
                sum1 += arr[i][i];
                sum2 += arr[99 - i][i];
            }
            max = Math.max(max, Math.max(sum1, sum2));
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
