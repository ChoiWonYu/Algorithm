package BOJ.random;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2512 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int budget = sc.nextInt();
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] * (n - i) <= budget) {
                budget -= arr[i];
                answer = Math.max(answer, arr[i]);
            } else {
                answer = Math.max(answer, budget / (n - i));
                break;
            }
        }
        System.out.println(answer);
    }

}
