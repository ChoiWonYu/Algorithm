package Programmers.random;

public class Pr150369 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        long deliveryCap = 0;
        long pickupCap = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curPickups = pickups[i];
            int curDeliveries = deliveries[i];
            if (deliveryCap >= curDeliveries && pickupCap >= curPickups) {
                deliveryCap -= curDeliveries;
                pickupCap -= curPickups;
                continue;
            }
            long maxValue =
                Math.max(curDeliveries - deliveryCap, curPickups - pickupCap);
            long cnt = maxValue % cap == 0
                ? maxValue / cap : maxValue / cap + 1;
            int dist = i + 1;

            deliveryCap += cap * cnt;
            pickupCap += cap * cnt;

            deliveryCap -= curDeliveries;
            pickupCap -= curPickups;

            answer += 2 * cnt * dist;
        }
        return answer;
    }
}
