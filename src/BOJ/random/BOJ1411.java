package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1411 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String w1 = words[i];
                String w2 = words[j];
                if (isShom(w1, w2)) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isShom(String w1, String w2) {
        Map<Character, Character> m = new HashMap<>();
        for (int i = 0; i < w1.length(); i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);
            if (m.containsKey(c1)) {
                if (m.get(c1) != c2) {
                    return false;
                }
            } else {
                if (m.containsValue(c2)) {
                    return false;
                }
                m.put(c1, c2);
            }
        }
        return true;
    }
}
