package BOJ.random;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2470 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        long answer1 = 0; long answer2 = 0;
        if (arr[0] * arr[n - 1] >= 0) {
            if (arr[0] >= 0) {
                answer1 = arr[0];
                answer2 = arr[1];
            } else {
                answer1 = arr[n - 2];
                answer2 = arr[n - 1];
            }

            System.out.println(answer1 + " " + answer2);
            return;
        }

        int lp = 0;
        int rp = n - 1;
        long minSum = Long.MAX_VALUE;

        while (lp < rp) {
            long cur = Math.abs(arr[lp] + arr[rp]);
            if (cur < minSum) {
                minSum = cur;
                answer1 = arr[lp];
                answer2 = arr[rp];
            }

            if (arr[lp] + arr[rp] < 0) {
                lp++;
            } else {
                rp--;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
