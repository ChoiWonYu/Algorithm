package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ2011 {

    static long cnt = 0;
    static Map<String, Long> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        dfs(input);
        System.out.print(cnt % 1000000);
    }

    public static void dfs(String cur) {
        if (cur.isEmpty()) {
            cnt = (cnt + 1) % 1000000;
            return;
        }

        long prev1 = cnt;
        int num1 = Integer.parseInt(cur.substring(0, 1));
        if (isValid(num1)) {
            String next1 = cur.substring(1);
            if (!next1.isEmpty() && m.containsKey(next1)) {
                cnt = (cnt + m.get(next1)) % 1000000;
            } else {
                dfs(next1);
                m.put(next1, cnt - prev1);
            }
        }

        long prev2 = cnt;
        if (cur.length() > 1) {
            int num2 = Integer.parseInt(cur.substring(0, 2));
            if (num2 >= 10 && isValid(num2)) {
                String next2 = cur.substring(2);
                if (!next2.isEmpty() && m.containsKey(next2)) {
                    cnt = (cnt + m.get(next2)) % 1000000;
                } else {
                    dfs(next2);
                    m.put(next2, cnt - prev2);
                }
            }
        }
    }

    public static boolean isValid(int num) {
        return num >= 1 && num <= 26;
    }
}
