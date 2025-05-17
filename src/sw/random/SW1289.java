package sw.random;

import java.util.Scanner;

public class SW1289 {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.next();
            String memory = "";
            for (int i = 0; i < input.length(); i++) {
                memory += "0";
            }

            int answer = 0;
            for (int i = 0; i < input.length(); i++) {
                if (memory.equals(input)) {
                    break;
                }

                if (memory.charAt(i) != input.charAt(i)) {
                    memory = changeBit(memory, i);
                    answer++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static String changeBit(final String memory, final int i) {
        char c = memory.charAt(i) == '1' ? '0' : '1';
        String plus = "";
        for (int j = i; j < memory.length(); j++) {
            plus += c;
        }
        return memory.substring(0, i) + plus;
    }
}
