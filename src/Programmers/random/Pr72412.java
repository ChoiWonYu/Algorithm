package Programmers.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr72412 {

    static final String SPLIT_STR = " ";
    static Map<String, List<Integer>> MAP = new HashMap<>();
    static List<List<String>> VALUE_LIST = List.of(List.of("cpp", "java", "python"),
        List.of("backend", "frontend"), List.of("junior", "senior"), List.of("chicken", "pizza"));

    public int[] solution(String[] info, String[] query) {
        for (String s : info) {
            String[] arr = s.split(SPLIT_STR);
            String key = "";
            for (int i = 0; i < arr.length - 1; i++) {
                key += arr[i] + SPLIT_STR;
            }
            key = key.trim();
            if (!MAP.containsKey(key)) {
                MAP.put(key, new ArrayList<>());
            }

            MAP.get(key).add(Integer.parseInt(arr[arr.length - 1]));
        }

        for (String s : MAP.keySet()) {
            Collections.sort(MAP.get(s));
        }
        List<Integer> answer = new ArrayList<>();

        for (String q : query) {
            String[] qArr = q.split(SPLIT_STR);
            List<String> keyList = new ArrayList<>();
            keyList.add("");
            int valueIdx = 0;
            for (int i = 0; i < qArr.length - 1; i++) {
                if (qArr[i].equals("and")) {
                    continue;
                }
                List<String> newList = new ArrayList<>();
                if (qArr[i].equals("-")) {
                    for (String k : keyList) {
                        for (String v : VALUE_LIST.get(valueIdx)) {
                            newList.add(k + v + SPLIT_STR);
                        }
                    }
                } else {
                    for (String k : keyList) {
                        newList.add(k + qArr[i] + SPLIT_STR);
                    }
                }
                keyList = newList;
                valueIdx++;
            }
            int sum = 0;
            int score = Integer.parseInt(qArr[qArr.length - 1]);
            for (String k : keyList) {
                sum += calculateSocre(k.trim(), score);
            }

            answer.add(sum);
        }
        return answer.stream()
                     .mapToInt(i -> i)
                     .toArray();
    }

    public int calculateSocre(String key, int score) {
        if (!MAP.containsKey(key)) {
            return 0;
        }
        List<Integer> scoreList = MAP.get(key);

        // 이진 탐색으로 score 이상의 값이 처음 나타나는 인덱스를 찾는다.
        int left = 0;
        int right = scoreList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scoreList.get(mid) >= score) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // score 이상인 원소의 개수는 (전체 개수 - lower_bound 인덱스)
        return scoreList.size() - left;
    }
}
