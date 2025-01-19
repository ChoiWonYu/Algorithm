package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Map<Character, String> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            boolean flag1 = false;
            boolean flag2 = false;
            String input = br.readLine();
            String[] arr = input.split(" ");

            // 첫 글자 확인
            for (int j = 0; j < arr.length; j++) {
                char curCh = Character.toLowerCase(arr[j].charAt(0));
                if (!m.containsKey(curCh)) {
                    m.put(Character.toLowerCase(curCh), input);
                    updateSb(sb, input, j, 0);
                    flag1 = true;
                    break;
                }
            }
            if (flag1) {
                continue;
            }

            // 왼쪽부터 확인
            for (int arrIdx = 0; arrIdx < arr.length; arrIdx++) {
                if (flag2) {
                    break;
                }
                String cur = arr[arrIdx];
                for (int j = 1; j < cur.length(); j++) {
                    if (!m.containsKey(Character.toLowerCase(cur.charAt(j)))) {
                        m.put(Character.toLowerCase(cur.charAt(j)), input);
                        updateSb(sb, input, arrIdx, j);
                        flag2 = true;
                        break;
                    }
                }
            }
            if (flag2) {
                continue;
            }

            // 단축키 지정 불가
            sb.append(input).append("\n");
        }

        System.out.println(sb);
    }

    public static void updateSb(StringBuilder sb, String input, int arrIdx, int strIdx) {
        String[] arr = input.split(" ");
        for (int ai = 0; ai < arr.length; ai++) {
            if (!(ai == arrIdx)) {
                sb.append(arr[ai]);
            } else {
                String s = arr[ai];
                for (int i = 0; i < s.length(); i++) {
                    if (i == strIdx) {
                        sb.append('[').append(s.charAt(i)).append(']');
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            sb.append(" ");
        }
        sb.append("\n");
    }
}
