package Programmers.random_2nd;

import java.util.*;

public class Pr138476 {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : tangerine) {
            m.put(i, m.getOrDefault(i, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(m.values());
        values.sort(Collections.reverseOrder());

        int answer = 0;
        for (int i : values) {
            k -= i;
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
