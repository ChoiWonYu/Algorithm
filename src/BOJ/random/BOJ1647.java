package BOJ.random;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1647 {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int m = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            pq.offer(new int[]{a, b, c});
        }

        long answer = 0;
        int cnt = 0;
        while (!pq.isEmpty() && cnt < n - 2) {
            int[] arr = pq.poll();
            int v1 = arr[0];
            int v2 = arr[1];
            int price = arr[2];
            if (find(v1) != find(v2)) {
                union(v1, v2);
                answer += price;
                cnt++;
            }
        }
        System.out.println(answer);
    }

    private static int find(final int n1) {
        if (arr[n1] == n1) {
            return n1;
        }
        return arr[n1] = find(arr[n1]);
    }

    private static void union(final int x, final int y) {
        int n1 = find(x), n2 = find(y);
        if (n1 != n2) {
            arr[n1] = n2;
        }
    }
}
