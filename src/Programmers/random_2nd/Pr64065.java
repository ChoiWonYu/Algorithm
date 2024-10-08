package Programmers.random_2nd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pr64065 {

    public int[] solution(String s) {
        List<String[]> sets = new ArrayList<>();
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '{') {
                int j = i + 1;
                StringBuilder sb = new StringBuilder();
                while (s.charAt(j) != '}') {
                    sb.append(s.charAt(j));
                    j++;
                }
                String set = sb.toString();
                String[] arr = set.split(",");
                sets.add(arr);
                i = j;
            }
        }
        Collections.sort(sets, (a, b) -> a.length - b.length);

        int limit = sets.size();
        List<Integer> result = new ArrayList<>();
        for (String[] stringArr : sets) {
            for (String string : stringArr) {
                Integer num = Integer.parseInt(string);
                if (!result.contains(num)) {
                    result.add(num);
                    break;
                }
            }
        }

        int[] resultArr = new int[limit];
        for (int i = 0; i < limit; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
