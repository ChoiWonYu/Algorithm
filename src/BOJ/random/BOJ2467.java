package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> d = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            d.add(Integer.parseInt(st.nextToken()));
        }
        int n1 = d.pollFirst();
        int n2 = d.pollLast();
        int min = Math.abs(n1 + n2);
        int minN1 = n1;
        int minN2 = n2;

        while (!d.isEmpty()) {
            int next1 = Math.abs(n1 + d.peekLast());
            int next2 = Math.abs(n2 + d.peekFirst());
            if (next1 < next2) {
                n2 = d.pollLast();
            } else {
                n1 = d.pollFirst();
            }

            if (min > Math.min(next1, next2)) {
                minN1 = n1;
                minN2 = n2;
                min = Math.abs(minN1 + minN2);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minN1)
          .append(" ")
          .append(minN2);

        System.out.println(sb);
    }

}
