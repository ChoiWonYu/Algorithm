package Programmers.random_2nd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pr92341 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, String> timeMap = new HashMap<>();
        Map<String, Integer> calTimeMap = new HashMap<>();
        String[] sp;
        for (String cur : records) {
            sp = cur.split(" ");
            String order = sp[2];
            String carNum = sp[1];
            String time = sp[0];

            if (order.equals("IN")) {
                timeMap.put(carNum, time);
            } else {
                putCalTime(timeMap, carNum, time, calTimeMap);
                timeMap.remove(carNum);
            }
        }

        for (String cn : timeMap.keySet()) {
            putCalTime(timeMap, cn, "23:59", calTimeMap);
        }

        Set<String> cars = calTimeMap.keySet();
        List<String> carNames = new ArrayList<>();
        for (String c : cars) {
            carNames.add(c);
        }
        Collections.sort(carNames);

        int[] result = new int[carNames.size()];
        for (int i = 0; i < cars.size(); i++) {
            result[i] = calculate(fees, calTimeMap.get(carNames.get(i)));
        }

        return result;
    }

    private void putCalTime(final Map<String, String> timeMap, final String carNum,
        final String time, final Map<String, Integer> calTimeMap) {
        String inTime = timeMap.get(carNum);
        int td = getTd(inTime, time);
        calTimeMap.put(carNum, calTimeMap.getOrDefault(carNum, 0) + td);
    }


    public int getTd(String inTime, String outTime) {
        String[] inArr = inTime.split(":");
        String[] outArr = outTime.split(":");
        return (Integer.parseInt(outArr[0]) - Integer.parseInt(inArr[0])) * 60 + (
            Integer.parseInt(outArr[1]) - Integer.parseInt(inArr[1]));
    }

    public int calculate(int[] fees, int time) {
        if (time >= fees[0]) {
            return fees[1] + (int) (Math.ceil((time - fees[0]) * 1.0 / fees[2])) * fees[3];
        }
        return fees[1];
    }
}
