package sw.random;

import java.util.Scanner;

public class SW1240 {

    public static String[] val = new String[]{"0001101", "0011001", "0010011", "0111101", "0100011",
        "0110001", "0101111", "0111011", "0110111", "0001011"};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            String bitCode = getCode(arr, n, m);
            String numCode = getNumCode(bitCode);

            int result = 0;
            if (isValid(numCode)) {
                for (int i = 0; i < 8; i++) {
                    result += numCode.charAt(i) - '0';
                }
            }
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static String getNumCode(final String bitCode) {
        String result = "";
        for (int i = 0; i < bitCode.length(); i += 7) {
            String cur = bitCode.substring(i, i + 7);
            for (int j = 0; j < val.length; j++) {
                if (cur.equals(val[j])) {
                    result += j;
                }
            }
        }
        return result;
    }

    private static boolean isValid(final String code) {
        int odd = 0, even = 0;
        for (int i = 0; i < code.length(); i++) {
            if ((i + 1) % 2 == 0) {
                even += (code.charAt(i) - '0');
            } else {
                odd += (code.charAt(i) - '0');
            }
        }
        return (odd * 3 + even) % 10 == 0;
    }

    private static String getCode(final String[] arr, final int n, final int m) {
        int targetR = -1;
        int targetC = -1;
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (arr[i].charAt(j) == '1') {
                    targetR = i;
                    targetC = j;
                    break;
                }
            }

            if (targetR != -1) {
                break;
            }
        }

        int startR = targetR;
        int startC = targetC - 55;
        return arr[startR].substring(startC, targetC + 1);
    }
}
