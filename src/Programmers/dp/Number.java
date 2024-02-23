package Programmers.dp;

import java.util.*;

public class Number {

    public int solution(int N, int number) {
        if (number == N) {
            return 1;
        }

        Set<Integer>[] dp = new HashSet[9];

        int dup = N;
        for (int i = 1; i <= 8; i++) {
            if (dup == number) {
                return i;
            }
            dp[i] = new HashSet<>();
            dp[i].add(dup);
            dup = Integer.parseInt(String.valueOf(dup) + N);
        }
        int[] cur = new int[4];
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp[i - j]) {
                    for (int num2 : dp[j]) {
                        cur[0] = num1 + num2;
                        cur[1] = num1 - num2;
                        cur[2] = num1 / num2;
                        cur[3] = num1 * num2;
                        for (int curNum : cur) {
                            if (curNum == 0) {
                                continue;
                            }
                            if (curNum == number) {
                                return i;
                            }
                            dp[i].add(curNum);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
