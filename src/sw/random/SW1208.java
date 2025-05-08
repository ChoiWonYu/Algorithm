package sw.random;

import java.util.Arrays;
import java.util.Scanner;

public class SW1208 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        int[] heights = new int[100];
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int d = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                heights[i] = sc.nextInt();
            }
            Arrays.sort(heights);

            for (int i = 0; i < d; i++) {
                heights[0]++;
                heights[99]--;
                Arrays.sort(heights);
            }

            sb.append("#").append(test_case).append(" ").append(heights[99]-heights[0]).append("\n");
            Arrays.fill(heights, 0);
        }

        System.out.println(sb);
    }

}
