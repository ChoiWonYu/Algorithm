package BOJ.random;

import java.util.Scanner;

public class BOJ1668 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 왼쪽 계산
        int max = 0;
        int leftCnt = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if (cur > max) {
                leftCnt++;
                max = cur;
            }
        }

        // 오른쪽 계산
        max = 0;
        int rightCnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = arr[i];
            if (cur > max) {
                rightCnt++;
                max = cur;
            }
        }

        System.out.println(leftCnt);
        System.out.println(rightCnt);
    }

}
