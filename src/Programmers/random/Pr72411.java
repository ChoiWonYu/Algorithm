package Programmers.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr72411 {

    static Map<String, Integer>[] courseMaps; // 길이별로 맵을 관리

    public String[] solution(String[] orders, int[] course) {
        courseMaps = new HashMap[11];
        for (int i = 0; i < 11; i++) {
            courseMaps[i] = new HashMap<>();
        }

        // 1. 각 order를 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        // 2. 각 order에 대해 course 길이에 맞는 조합을 생성하고 카운트
        for (String order : orders) {
            for (int len : course) {
                if (order.length() >= len) {
                    findCombinations(order, "", len, 0);
                }
            }
        }

        // 3. 각 course 길이별로 가장 많이 주문된 메뉴(들)를 찾기
        List<String> answerList = new ArrayList<>();
        for (int len : course) {
            Map<String, Integer> map = courseMaps[len];
            if (map.isEmpty()) {
                continue;
            }

            // value(주문 횟수)의 최댓값 찾기
            int maxCount = Collections.max(map.values());

            // 최소 2번 이상 주문된 경우만
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        answerList.add(entry.getKey());
                    }
                }
            }
        }

        // 4. 최종 결과를 사전순으로 정렬
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);
    }

    // 조합을 찾는 재귀 함수
    public void findCombinations(String order, String current, int len, int startIdx) {
        if (current.length() == len) {
            courseMaps[len].put(current, courseMaps[len].getOrDefault(current, 0) + 1);
            return;
        }

        for (int i = startIdx; i < order.length(); i++) {
            findCombinations(order, current + order.charAt(i), len, i + 1);
        }
    }
}
