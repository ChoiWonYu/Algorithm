package BOJ.random;

import java.util.Scanner;

public class BOJ1145 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        while (!isValid(arr, answer)) {
            answer++;
        }
        System.out.println(answer);
        sc.close();
    }

    private static boolean isValid(final int[] arr, final int num) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (num >= arr[i] && num % arr[i] == 0) {
                cnt++;
            }
        }
        return cnt >= 3;
    }

}
