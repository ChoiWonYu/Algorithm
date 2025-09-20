package Programmers.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Pr92341 {

    static int[] FEES;

    public int[] solution(int[] fees, String[] records) {
        FEES = fees;
        Map<String, Integer> timeSumMap = new TreeMap<>();
        Map<String, String> inMap = new HashMap<>();
        for (String record : records) {
            String[] arr = record.split(" ");
            String time = arr[0];
            String car = arr[1];
            String inOut = arr[2];

            if (inOut.equals("IN")) {
                // 차가 들어왔을 때
                inMap.put(car, time);
            } else {
                // 차가 나갔을 때
                int t = calculateTime(inMap.get(car), time);
                timeSumMap.put(car, timeSumMap.getOrDefault(car, 0) + t);
                inMap.remove(car);
            }
        }

        for (String c : inMap.keySet()) {
            int time = calculateTime(inMap.get(c), "23:59");
            timeSumMap.put(c, timeSumMap.getOrDefault(c, 0) + time);
        }

        List<Integer> answer = new ArrayList<>();
        for (String car : timeSumMap.keySet()) {
            answer.add(calculateFee(timeSumMap.get(car)));
            // System.out.println("car : " + car);
            // System.out.println("time : " + timeSumMap.get(car));
            // System.out.println("fee : " + calculateFee(timeSumMap.get(car)));
            // System.out.println();
        }
        return answer.stream()
                     .mapToInt(a -> a)
                     .toArray();
    }

    public int calculateTime(String inTime, String outTime) {
        String[] inArr = inTime.split(":");
        String[] outArr = outTime.split(":");

        int inHour = Integer.parseInt(inArr[0]);
        int inMinutes = Integer.parseInt(inArr[1]);
        int outHour = Integer.parseInt(outArr[0]);
        int outMinutes = Integer.parseInt(outArr[1]);

        return (outHour - inHour) * 60 + outMinutes - inMinutes;
    }

    public int calculateFee(int sumMin) {
        return sumMin <= FEES[0] ? FEES[1]
            : FEES[1] + (int) (Math.ceil((double) (sumMin - FEES[0]) / FEES[2]) * FEES[3]);
    }
}
