package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1946 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> fresh = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());

                fresh.add(new int[]{s1, s2});
            }

            Collections.sort(fresh, Comparator.comparingInt(a -> a[0]));
            int[] first = fresh.get(0);
            int min = first[1];

            int answer = n;
            for (int[] s : fresh) {
                if (s[1] > min) {
                    answer--;
                }
                min = Math.min(min, s[1]);
            }

            System.out.println(answer);
        }
    }

}
