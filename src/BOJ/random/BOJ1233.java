package BOJ.random;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1233 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    map.put(i + j + k, map.getOrDefault(i + j + k, 0) + 1);
                }
            }
        }

        int answer = -1;
        int answerCnt = -1;
        for (int n : map.keySet()) {
            if (map.get(n) > answerCnt || (map.get(n) == answerCnt && n < answer)) {
                answer = n;
                answerCnt = map.get(n);
            }
        }
        System.out.println(answer);
    }

}
