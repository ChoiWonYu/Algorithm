package BOJ.random;

import java.util.Scanner;

public class BOJ1568 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int remain = sc.nextInt();
        int minus = 1;
        int answer = 0;
        while (remain > 0) {
            if (minus > remain) {
                minus = 1;
            }

            remain -= minus;
            minus++;
            answer++;
        }
        System.out.println(answer);
    }

}
