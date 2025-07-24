package BOJ.random;

import java.util.Scanner;

public class BOJ2805 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long lp = 0;
        long rp = 1_000_000_001;
        while (lp + 1 < rp) {
            long mid = (lp + rp) / 2;
            if (isValid(arr, m, mid)) {
                lp = mid;
            } else {
                rp = mid;
            }
        }
        System.out.println(lp);
    }

    public static boolean isValid(int[] arr, int m, long num) {
        long cur = 0;
        for (int n : arr) {
            if (num < n) {
                cur += n - num;
            }
            if (cur >= m) {
                return true;
            }
        }
        return false;
    }

}
