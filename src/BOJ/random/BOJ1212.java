package BOJ.random;

import java.util.Scanner;

public class BOJ1212 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int cur = input.charAt(i) - '0';
            int n = 4;
            for (int j = 0; j < 3; j++) {
                if (cur >= n) {
                    sb.append(1);
                    cur -= n;
                } else {
                    sb.append(0);
                }
                n /= 2;
            }
        }
        while (!sb.toString().equals("0") && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }

}
