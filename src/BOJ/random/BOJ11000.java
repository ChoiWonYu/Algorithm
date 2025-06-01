package BOJ.random;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ11000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        PriorityQueue<int[]> deque = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int answer = 0;
        for (int[] cur : arr) {
            int s = cur[0];
            int e = cur[1];
            while(!deque.isEmpty() && deque.peek()[1] <= s) {
                deque.poll();
            }
            deque.add(new int[]{s, e});
            answer = Math.max(answer, deque.size());
        }
        System.out.println(answer);
    }
}
