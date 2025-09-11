package Programmers.random;

import java.util.HashMap;
import java.util.Map;

public class Pr258712 {

    public static void main(String[] args) {

    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftGraph = new HashMap<>();
        Map<String, Integer> giftPoint = new HashMap<>();
        Map<String, Integer> giftCnt = new HashMap<>();

        // graph 초기화
        for (String f1 : friends) {
            giftGraph.put(f1, new HashMap<>());
            giftPoint.put(f1, 0);
            giftCnt.put(f1, 0);
            for (String f2 : friends) {
                if (f1.equals(f2)) {
                    continue;
                }
                giftGraph.get(f1).put(f2, 0);
            }
        }

        // graph 값 삽입
        for (String g : gifts) {
            String[] arr = g.split(" ");
            String f1 = arr[0];
            String f2 = arr[1];
            giftGraph.get(f1).put(f2, giftGraph.get(f1).get(f2) + 1);
            giftPoint.put(f2, giftPoint.get(f2) - 1);
            giftPoint.put(f1, giftPoint.get(f1) + 1);
        }

        // System.out.println(giftPoint);
        // for(String f : friends){
        //     System.out.println(f);
        //     System.out.println(giftGraph.get(f));
        //     System.out.println();
        // }

        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String f1 = friends[i];
                String f2 = friends[j];

                int f1ToF2 = giftGraph.get(f1).get(f2);
                int f2ToF1 = giftGraph.get(f2).get(f1);

                if (f1ToF2 > f2ToF1) {
                    giftCnt.put(f1, giftCnt.get(f1) + 1);
                } else if (f1ToF2 < f2ToF1) {
                    giftCnt.put(f2, giftCnt.get(f2) + 1);
                } else {
                    int f1Point = giftPoint.get(f1);
                    int f2Point = giftPoint.get(f2);

                    if (f1Point > f2Point) {
                        giftCnt.put(f1, giftCnt.get(f1) + 1);
                    } else if (f1Point < f2Point) {
                        giftCnt.put(f2, giftCnt.get(f2) + 1);
                    }
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (String f : friends) {
            answer = Math.max(answer, giftCnt.get(f));
        }
        return answer;
    }
}
