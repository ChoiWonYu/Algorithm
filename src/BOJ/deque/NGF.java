package BOJ.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class NGF {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cntArr = new int[1000001];
        int i, num, n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;

        int[] numArr = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (i = 0; i < n; i++) {
            num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
            cntArr[num]++;
        }

        deque.offer(index);
        for (i = 1; i < n; i++) {
            while (!deque.isEmpty() && cntArr[numArr[deque.peek()]] < cntArr[numArr[i]]) {
                result[deque.pop()] = numArr[i];
            }
            deque.push(i);
        }

        while (!deque.isEmpty()) {
            result[deque.pop()] = -1;
        }

        for (i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }

}
