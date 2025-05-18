package sw.random;

import java.util.Scanner;

public class SW1213 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.setLength(0);
            sc.next();
            String keyword = sc.next();
            String input = sc.next();
            int answer = 0;
            for (int i = 0; i < keyword.length(); i++) {
                sb.append(input.charAt(i));
            }
            if (sb.toString().equals(keyword)) {
                answer++;
            }
            for (int i = keyword.length(); i < input.length(); i++) {
                sb.deleteCharAt(0);
                sb.append(input.charAt(i));
                System.out.println(test_case + " " + sb);
                if (sb.toString().equals(keyword)) {
                    answer++;
                }
            }
            result.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(result);
    }

}
