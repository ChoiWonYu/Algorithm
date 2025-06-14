package BOJ.random;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1922 {

    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            int price = sc.nextInt();
            pq.offer(new int[]{p1, p2, price});
        }

        int cnt = 0;
        long answer = 0;
        while (!pq.isEmpty() && cnt < n - 1) {
            int[] cur = pq.poll();
            int p1 = cur[0];
            int p2 = cur[1];
            int price = cur[2];

            if (find(p1) == find(p2)) {
                continue;
            }
            union(p1, p2);
            cnt++;
            answer += price;
        }

        System.out.println(answer);
    }

    public static void union(int p1, int p2) {
        int n1 = find(p1);
        int n2 = find(p2);
        arr[n1] = n2;
    }

    public static int find(int p) {
        if (p == arr[p]) {
            return p;
        }
        return arr[p] = find(arr[p]);
    }
}
