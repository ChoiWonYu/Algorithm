package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1342 {

    public static int[] alph;
    public static int n, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        n = input.length();
        alph = new int[27];

        for (int i = 0; i < n; i++) {
            alph[input.charAt(i) - 'a']++;
        }

        dfs("", '?');

        System.out.println(answer);
    }

    public static void dfs(String cur, char prev) {
        if (cur.length() == n) {
            answer++;
            return;
        }
        for (int i = 0; i < 27; i++) {
            char curAlph = (char) (i + 'a');
            if (alph[i] == 0 || prev == curAlph) {
                continue;
            }
            alph[i]--;
            dfs(cur + curAlph, curAlph);
            alph[i]++;
        }
    }
}
