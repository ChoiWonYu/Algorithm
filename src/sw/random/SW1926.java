package sw.random;

import java.util.Scanner;

public class SW1926 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String num = String.valueOf(i);
            int count = getTargetCount(num);

            if (count == 0) {
                sb.append(i);
            } else {
                for (int j = 0; j < count; j++) {
                    sb.append("-");
                }
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static int getTargetCount(final String num) {
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            char cur = num.charAt(i);
            if (cur == '3' || cur == '6' || cur == '9') {
                cnt++;
            }
        }
        return cnt;
    }
}
