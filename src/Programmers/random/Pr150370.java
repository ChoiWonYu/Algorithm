package Programmers.random;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr150370 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = convertStringToDate(today);
        Map<String, Integer> expiredMap = new HashMap<>();

        // 정책별 유효기간
        for (String term : terms) {
            String[] arr = term.split(" ");
            expiredMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        List<Integer> result = new ArrayList<>();
        // 유효기간이 지난 정책 검사
        for (int i = 0; i < privacies.length; i++) {
            String pr = privacies[i];
            String[] arr = pr.split(" ");
            String dateStr = arr[0];
            String term = arr[1];

            LocalDate expiredAt = convertStringToDate(dateStr)
                .plusMonths(expiredMap.get(term));

            if (!expiredAt.isAfter(todayDate)) {
                result.add(i + 1);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public LocalDate convertStringToDate(String date) {
        String[] arr = date.split("[^0-9]");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);

        return LocalDate.of(year, month, day);
    }
}
