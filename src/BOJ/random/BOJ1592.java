package BOJ.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1592 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int curIdx = 0;
        int answer = 0;
        map.put(curIdx, 1);
        while (map.getOrDefault(curIdx, 0) < m) {
            int cnt = map.getOrDefault(curIdx, 0);
            if (cnt % 2 == 0) {
                curIdx = (curIdx + l) % n;
            } else {
                curIdx = (n + curIdx - l) % n;
            }
            map.put(curIdx, map.getOrDefault(curIdx, 0) + 1);
            answer++;
        }
        System.out.println(answer);
    }

}
