package Programmers.random_2nd;

import java.util.*;

public class Pr138476 {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i : tangerine) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }
        List<Integer> values = new ArrayList<>(m.values());
        Collections.sort(values);

        int answer = 0;
        for (int i = values.size() - 1; i >= 0; i--) {
            int n = values.get(i);
            k -= n;
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }
}
