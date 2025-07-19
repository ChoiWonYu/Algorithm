package BOJ.random;

import java.util.Scanner;

public class BOJ1526 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (!isValid(n)) {
            n--;
        }
        System.out.println(n);
    }

    public static boolean isValid(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '4' && s.charAt(i) != '7') {
                return false;
            }
        }
        return true;
    }

}
