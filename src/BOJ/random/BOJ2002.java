package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BOJ2002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<String> d = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            d.addLast(br.readLine());
        }

        Set<String> s = new HashSet<>();
        int answer = 0;
        for (String car : d) {
            if (s.contains(car)) {
                continue;
            }
            String out = br.readLine();
            while (!car.equals(out)) {
                answer++;
                s.add(out);
                out = br.readLine();
            }
        }

        System.out.println(answer);
    }

}
