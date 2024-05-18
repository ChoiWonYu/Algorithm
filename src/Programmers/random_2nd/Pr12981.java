package Programmers.random_2nd;

import java.util.*;

public class Pr12981 {

    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        String first = words[0];
        char last = first.charAt(first.length() - 1);
        set.add(first);
        int cnt = 1;
        int turn = 1;
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            turn = (turn + 1) % n;

            if (last != cur.charAt(0) || set.contains(cur)) {
                return new int[]{(turn == 0 ? n : turn), cnt};
            }
            set.add(cur);
            last = cur.charAt(cur.length() - 1);
            if ((i + 1) % n == 0) {
                cnt++;
            }
        }

        return new int[]{0, 0};
    }
}
