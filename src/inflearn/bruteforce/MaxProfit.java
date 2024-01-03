package inflearn.bruteforce;

import java.io.*;
import java.util.*;

class Study implements Comparable<Study> {

    int profit;
    int day;
    boolean visited;

    public Study(final int profit, final int day, final boolean visited) {
        this.profit = profit;
        this.day = day;
        this.visited = visited;
    }

    public int compareTo(Study study) {
        return day == study.day ? profit - study.profit : day - study.day;
    }
}

public class MaxProfit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Study> studies = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            studies.add(new Study(p, d, false));
        }

        Collections.sort(studies);
        PriorityQueue<Study> d = new PriorityQueue<>((a, b) -> a.profit - b.profit);

        for (int i = 0; i < n; i++) {
            Study target = studies.get(i);
            if (d.size() < target.day) {
                d.add(target);
            } else if (!d.isEmpty() && d.peek().profit < target.profit) {
                d.poll();
                d.add(target);
            }
        }

        long sum = d.stream()
            .mapToInt(s -> s.profit)
            .sum();

        System.out.println(sum);
    }

}
