package sw.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SW1216 {

    static int answer;
    static Set<String> visited;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            visited.clear();
            answer = 1;
            char[][] board = new char[100][100];
            int tc = sc.nextInt();
            for (int i = 0; i < 100; i++) {
                String input = sc.next();
                for (int j = 0; j < 100; j++) {
                    board[i][j] = input.charAt(j);
                }
            }
            StringBuilder cur = new StringBuilder();

            // 가로
            for (int i = 0; i < 100; i++) {
                cur.setLength(0);
                for (int j = 0; j < 100; j++) {
                    cur.append(board[i][j]);
                    calculate(cur.toString());
                }
            }

            // 세로
            for (int i = 0; i < 100; i++) {
                cur.setLength(0);
                for (int j = 0; j < 100; j++) {
                    cur.append(board[j][i]);
                    calculate(cur.toString());
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void calculate(final String string) {
        for (int i = 0; i < string.length(); i++) {
            isPalindrome(string.substring(i));
        }
    }

    private static void isPalindrome(final String substring) {
        if (visited.contains(substring)) {
            return;
        }

        for (int i = 0; i < substring.length() / 2; i++) {
            if (substring.charAt(i) != substring.charAt(substring.length() - 1 - i)) {
                return;
            }
        }
        visited.add(substring);
        answer = Math.max(answer, substring.length());
    }
}
