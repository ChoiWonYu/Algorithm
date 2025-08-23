package BOJ.random;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ2407 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        m = Math.min(m, n - m);
        System.out.println(m);
        BigInteger answer = BigInteger.ONE;
        for (int i = n; i > n - m; i--) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        for (int i = 2; i <= m; i++) {
            answer = answer.divide(BigInteger.valueOf(i));
        }
        System.out.println(answer);
    }
}
