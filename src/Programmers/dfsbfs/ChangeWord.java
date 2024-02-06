package Programmers.dfsbfs;

import java.util.*;

public class ChangeWord {

    public int solution(String begin, String target, String[] words) {
        int l = words.length;
        Deque<String> d = new LinkedList<>();
        int cnt = 0;
        boolean[] visited = new boolean[l];
        d.add(begin);
        while (!d.isEmpty()) {
            int len = d.size();
            for (int i = 0; i < len; i++) {
                String cur = d.pop();
                System.out.println(cur);
                if (cur.equals(target)) {
                    return cnt;
                }
                for (int j = 0; j < l; j++) {
                    String t = words[j];
                    if (target.equals(cur)) {
                        continue;
                    }
                    if (!visited[j] && canSwitch(cur, t)) {
                        visited[j] = true;
                        d.add(words[j]);
                    }
                }
            }
            cnt++;
        }
        return 0;
    }

    public boolean canSwitch(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (cnt > 1) {
                return false;
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

}
