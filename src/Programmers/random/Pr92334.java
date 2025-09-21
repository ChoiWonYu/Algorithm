package Programmers.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pr92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCntMap = new HashMap<>();
        for (String id : id_list) {
            reportMap.put(id, new HashSet<String>());
            reportCntMap.put(id, 0);
        }

        for (String rep : report) {
            String[] arr = rep.split(" ");
            String reporter = arr[0];
            String reported = arr[1];

            if (!reportMap.get(reporter).contains(reported)) {
                reportCntMap.put(reported, reportCntMap.get(reported) + 1);
            }
            reportMap.get(reporter).add(reported);
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            for (String reported : reportMap.get(id)) {
                if (reportCntMap.get(reported) >= k) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
