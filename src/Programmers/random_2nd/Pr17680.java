package Programmers.random_2nd;

import java.util.Deque;
import java.util.LinkedList;

public class Pr17680 {

    private static final int CACHE_HIT_TIME = 1;
    private static final int CACHE_MISS_TIME = 5;

    public int solution(int cacheSize, String[] cities) {
        int totalTime = 0;
        Deque<String> d = new LinkedList<>();
        for (String city : cities) {
            city = city.toUpperCase();
            if (!d.contains(city)) {
                totalTime += CACHE_MISS_TIME;
                if (cacheSize > 0) {
                    if (d.size() >= cacheSize) {
                        d.pollFirst();
                    }
                    d.offerLast(city);
                }
            } else {
                totalTime += CACHE_HIT_TIME;
                d.remove(city);
                d.offerLast(city);
            }
        }
        return totalTime;
    }
}
