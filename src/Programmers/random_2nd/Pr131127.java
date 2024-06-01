package Programmers.random_2nd;

import java.util.*;

public class Pr131127 {

    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String cur = discount[i];
            m.put(cur, m.getOrDefault(cur, 0) + 1);
        }
        int answer = 0;
        int lp = 0;
        int rp = 9;
        while (true) {
            if (isValid(want, number, m)) {
                answer++;
            }

            m.put(discount[lp], m.get(discount[lp]) - 1);
            lp++;
            rp++;
            if (rp >= discount.length) {
                break;
            }
            m.put(discount[rp], m.getOrDefault(discount[rp], 0) + 1);
        }

        return answer;
    }

    public boolean isValid(String[] want, int[] numbers, Map<String, Integer> m) {
        for (int i = 0; i < want.length; i++) {
            if (m.getOrDefault(want[i], 0) < numbers[i]) {
                return false;
            }
        }
        return true;
    }
}
