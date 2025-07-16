package BOJ.random;

import java.util.Scanner;

public class BOJ1225 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n1 = sc.next();
        String n2 = sc.next();

        long sum = 0;
        for (int i = 0; i < n1.length(); i++) {
            int cur1 = n1.charAt(i) - '0';
            for (int j = 0; j < n2.length(); j++) {
                int cur2 = n2.charAt(j) - '0';
                sum += cur1 * cur2;
            }
        }
        System.out.println(sum);
    }

}
