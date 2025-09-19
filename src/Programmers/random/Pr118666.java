package Programmers.random;

import java.util.HashMap;
import java.util.Map;

public class Pr118666 {

    static final int MIDDLE_VALUE = 4;
    static String[] KINDS = new String[]{"RT", "CF", "JM", "AN"};

    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        for (String kind : KINDS) {
            char kind1 = kind.charAt(0);
            char kind2 = kind.charAt(1);
            map.put(kind1, 0);
            map.put(kind2, 0);
        }

        int len = survey.length;
        for (int i = 0; i < len; i++) {
            String sur = survey[i];
            int choice = choices[i];
            char scoreKind;
            if (choice > MIDDLE_VALUE) {
                scoreKind = sur.charAt(1);
                map.put(scoreKind, map.get(scoreKind) + choice - MIDDLE_VALUE);
            } else if (choice < MIDDLE_VALUE) {
                scoreKind = sur.charAt(0);
                map.put(scoreKind, map.get(scoreKind) + MIDDLE_VALUE - choice);
            }
        }

        String answer = "";
        for (String kind : KINDS) {
            char kind1 = kind.charAt(0);
            char kind2 = kind.charAt(1);

            if (map.get(kind1) > map.get(kind2)) {
                answer += kind1;
            } else if (map.get(kind1) < map.get(kind2)) {
                answer += kind2;
            } else {
                answer += (char) Math.min((int) kind1, (int) kind2);
            }
        }
        return answer;
    }
}
