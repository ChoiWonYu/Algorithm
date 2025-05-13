package sw.random;

import java.util.Scanner;

public class SW1215 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;
        StringBuilder answer = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            char[][] arr = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String input = sc.next();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = input.charAt(j);
                }
            }

            int cnt = 0;

            // 가로
            for (int i = 0; i < 8; i++) {
                cur.setLength(0);
                for (int j = 0; j < n; j++) {
                    cur.append(arr[i][j]);
                }
                if (isPalindrome(cur.toString())) {
                    cnt++;
                }
                for (int j = n; j < 8; j++) {
                    cur.append(arr[i][j]).deleteCharAt(0);
                    if (isPalindrome(cur.toString())) {
                        cnt++;
                    }
                }
            }

            // 세로
            for (int i = 0; i < 8; i++) {
                cur.setLength(0);
                for (int j = 0; j < n; j++) {
                    cur.append(arr[j][i]);
                }
                if (isPalindrome(cur.toString())) {
                    cnt++;
                }
                for (int j = n; j < 8; j++) {
                    cur.append(arr[j][i]).deleteCharAt(0);
                    if (isPalindrome(cur.toString())) {
                        cnt++;
                    }
                }
            }

            answer.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        System.out.println(answer);
    }

    private static boolean isPalindrome(final String string) {
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
