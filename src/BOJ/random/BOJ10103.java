package BOJ.random;

import java.util.Scanner;

public class BOJ10103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p1 = 100;
        int p2 = 100;

        for (int i = 1; i <= n; i++) {
            int s1 = sc.nextInt();
            int s2 = sc.nextInt();
            if (s1 > s2) {
                p2 -= s1;
            } else if (s2 > s1) {
                p1 -= s2;
            }
        }
        System.out.println(p1);
        System.out.println(p2);
    }
}
