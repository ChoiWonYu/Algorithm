package sw.random;

import java.util.Scanner;

public class SW2007 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.next();
            for (int i = 1; i <= 10; i++) {
                int cur = i;
                String prev = input.substring(0, cur);
                String s = "";
                for (int j = 0; j < 30 / cur; j++) {
                    s += prev;
                }
                if (input.contains(s)) {
                    sb.append("#").append(test_case).append(" ").append(cur).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

}
