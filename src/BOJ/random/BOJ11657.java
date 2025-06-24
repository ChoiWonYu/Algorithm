package BOJ.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ11657 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> edge = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int price = sc.nextInt();
            edge.add(new int[]{start, end, price});
        }
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int[] e : edge) {
                int start = e[0];
                int end = e[1];
                int price = e[2];
                if (dist[start] != Integer.MAX_VALUE && dist[end] > dist[start] + price) {
                    dist[end] = dist[start] + price;
                }
            }
        }

        for(int[] e : edge) {
            int start = e[0];
            int end = e[1];
            int price = e[2];
            if(dist[start] != Integer.MAX_VALUE && dist[end] > dist[start] + price) {
                System.out.println(-1);
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
    }
}
