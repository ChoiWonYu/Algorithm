package Programmers.binary_search;

import java.util.*;

public class ImmigrationScreening {

    public long solution(int n, int[] times) {
        int min = Arrays.stream(times)
            .min()
            .getAsInt();
        long lp = 0;
        long rp = (long) n * min;
        while (lp + 1 < rp) {
            long mid = (lp + rp) / 2;
            if (!check(mid, times, n)) {
                lp = mid;
            } else {
                rp = mid;
            }
        }
        return rp;
    }

    public boolean check(long value, int[] times, int n) {
        long sum = 0;
        for (int t : times) {
            sum += value / t;
        }
        return sum >= n;
    }
}
