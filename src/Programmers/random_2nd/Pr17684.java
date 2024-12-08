package Programmers.random_2nd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr17684 {

    public int[] solution(String msg) {
        Map<String, Integer> dic = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dic.put(Character.toString((char) ('A' + i)), i + 1);
        }

        List<Integer> answer = new ArrayList<>();
        int num = 27;
        int i = 0;

        while (i < msg.length()) {
            String cur = Character.toString(msg.charAt(i));
            int j = i + 1;

            while (j <= msg.length() && dic.containsKey(msg.substring(i, j))) {
                cur = msg.substring(i, j);
                j++;
            }

            answer.add(dic.get(cur));
            if (j <= msg.length()) {
                dic.put(msg.substring(i, j), num++);
            }

            i += cur.length();
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
