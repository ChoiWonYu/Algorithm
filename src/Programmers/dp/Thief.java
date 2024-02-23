package Programmers.dp;

import java.util.*;

public class Thief {

    public int solution(int[] money) {
        int len = money.length;
        int[] dp1 = new int[len - 1];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[1], money[0]);

        for (int i = 2; i < len - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + money[i], dp1[i - 1]);
        }

        int max1 = Arrays.stream(dp1)
            .max()
            .getAsInt();

        int[] dp2 = new int[len - 1];
        dp2[0] = money[1];
        dp2[1] = Math.max(money[2], money[1]);

        for (int i = 2; i < len - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + money[i + 1], dp2[i - 1]);
        }

        int max2 = Arrays.stream(dp2)
            .max()
            .getAsInt();

        return Math.max(max1, max2);
    }
}
