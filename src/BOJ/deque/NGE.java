package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class NGE {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        Arrays.fill(arr, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        deque.offer(index);
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && arr[deque.peek()] < arr[i]) {
                arr[deque.pop()] = arr[i];
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            arr[deque.pop()] = -1;
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
