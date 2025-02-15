package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1802 {

    private static String input;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input = br.readLine();
            if (check(0, input.length() - 1)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean check(int start, int end) {
        if (start == end) {
            return true;
        }
        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            if (input.charAt(i) == input.charAt(end - i)) {
                return false;
            }
        }
        return check(start, mid - 1) && check(mid + 1, end);
    }
}
