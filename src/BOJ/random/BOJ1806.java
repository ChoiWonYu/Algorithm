package BOJ.random;

import java.util.Scanner;

public class BOJ1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        int lp = 0;
        int sum = 0;

        for (int rp = 0; rp < n; rp++) {
            sum += arr[rp];
            if (sum >= s) {
                while (sum >= s) {
                    answer = Math.min(answer, rp - lp + 1);
                    sum -= arr[lp];
                    lp++;
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }

}
