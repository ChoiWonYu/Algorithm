package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while (true) {
            if (isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                br.close();
                return;
            }
            n++;
        }
    }

    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(long num) {
        String s = Long.toString(num);
        int len = s.length();
        for (int i = 0; i <= len / 2; i++) {
            if (s.charAt(i) != s.charAt((len - 1) - i)) {
                return false;
            }
        }
        return true;
    }

}
