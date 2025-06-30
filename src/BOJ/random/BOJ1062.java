package BOJ.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1062 {

    static int n, k, answer = 0;
    static String[] arr;
    static boolean[] learned;
    static Set<Character> s = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        learned = new boolean[26];
        learned[0] = true;
        learned['n' - 'a'] = true;
        learned['t' - 'a'] = true;
        learned['i' - 'a'] = true;
        learned['c' - 'a'] = true;

        if (k < 5) {
            System.out.println(0);
            return;
        }

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = preprocess(sc.next());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(final int learnCnt, final int prevIdx) {
        if (learnCnt == k - 5) {
            calculateAnswer();
            return;
        }

        for (int i = prevIdx + 1; i < 26; i++) {
            if (learned[i]) {
                continue;
            }
            s.add((char) ('a' + i));
            dfs(learnCnt + 1, i);
            s.remove((char) ('a' + i));
        }
    }

    private static void calculateAnswer() {
        int cnt = 0;
        boolean flag;
        for (String str : arr) {
            flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (!learned[str.charAt(i) - 'a'] && !s.contains(str.charAt(i))) {
                    flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        answer = Math.max(cnt, answer);
    }

    private static String preprocess(final String next) {
        String s = "";
        for (int i = 0; i < next.length(); i++) {
            if (!learned[next.charAt(i) - 'a']) {
                s += next.charAt(i);
            }
        }
        return s;
    }
}
