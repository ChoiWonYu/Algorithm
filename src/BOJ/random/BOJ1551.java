package BOJ.random;

import java.util.Scanner;

public class BOJ1551 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] init = new int[n];
        String[] input = sc.next().split(",");
        for (int i = 0; i < n; i++) {
            init[i] = Integer.parseInt(input[i]);
        }
        int[] cur = init;
        for (int i = 0; i < k; i++) {
            cur = exchange(cur);
        }

        for (int i = 0; i < cur.length; i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(cur[i]);
        }
    }

    private static int[] exchange(final int[] init) {
        int[] result = new int[init.length - 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = init[i + 1] - init[i];
        }
        return result;
    }

}
