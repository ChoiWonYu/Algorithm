package BOJ.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2056 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<int[]>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        int[] price = new int[n + 1];
        int[] times = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
            int p = sc.nextInt();
            price[i] = p;
            int priorityJobCnt = sc.nextInt();
            for (int j = 0; j < priorityJobCnt; j++) {
                int job = sc.nextInt();
                graph.get(job).add(new int[]{i, price[job]});
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int[] next : graph.get(i)) {
                times[next[0]] = Math.max(times[next[0]], times[i] + next[1]);
            }
        }
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, times[i] + price[i]);
        }
        System.out.println(answer);
    }
}
