package sw.random;

import java.util.Scanner;

public class SW1234 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            String input = sc.next();
            while (true) {
                String next = removeInput(input);
                if (next == null) {
                    break;
                } else {
                    input = next;
                }
            }
            System.out.println("#" + test_case + " " + input);
        }
    }

    public static String removeInput(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                String tmp = input.substring(0, i);
                String tmp2 = i + 1 == input.length() - 1 ? "" : input.substring(i + 2);
                input = tmp + tmp2;
                return input;
            }
        }
        return null;
    }
}
