package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String target = br.readLine();
        int tLen = target.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            // 폭발 문자열 길이 이상일 때만 검사
            if (sb.length() >= tLen) {
                boolean isMatch = true;
                for (int j = 0; j < tLen; j++) {
                    if (sb.charAt(sb.length() - tLen + j) != target.charAt(j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch) {
                    sb.delete(sb.length() - tLen, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
