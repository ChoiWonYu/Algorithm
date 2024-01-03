package inflearn.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Discuss implements Comparable<Discuss> {

    int start;
    int end;

    public Discuss(final int start, final int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Discuss discuss) {
        return start - discuss.start;
    }
}

public class DiscussRoom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Discuss> d = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d.add(new Discuss(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(d);
        int result = 1;
        int minEnd = d.get(0).end;
        for (int i = 1; i < n; i++) {

            minEnd = Math.min(d.get(i).end, minEnd);

            if (minEnd <= d.get(i).start) {
                result++;
                minEnd = d.get(i).end;
            }
        }
        System.out.println(result);
    }

}
