package Programmers.binary_search;

import java.util.*;

public class SteppingStones {

    public int solution(int distance, int[] rocks, int n) {
        int len = rocks.length;
        Arrays.sort(rocks);
        int lp = 1;
        int rp = distance + 1;

        while (lp + 1 < rp) {
            int mid = (lp + rp) / 2;
            if (isValid(rocks, n, mid, distance)) {
                lp = mid;
            } else {
                rp = mid;
            }
        }
        return lp;
    }

    public boolean isValid(int[] arr, int limit, int value, int dis) {
        int usedRocks = 0;
        int next = value;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= next) {
                next = arr[i] + value;
            } else {
                usedRocks++;
            }
        }
        if (dis < next) {
            usedRocks++;
        }

        return usedRocks <= limit;
    }
}
