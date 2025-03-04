package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1263 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<int[]> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            times.add(new int[]{t, s});
        }

        Collections.sort(times, Comparator.comparingInt(a -> a[1]));

        if(!isValid(0, times)){
            System.out.println(-1);
            return;
        }

        int rp = 1000000;
        int lp = 0;

        while (lp + 1 < rp) {
            int mid = (rp + lp) / 2;
            if(isValid(mid, times)){
                lp = mid;
            } else {
                rp = mid;
            }
        }

        System.out.println(lp);
    }

    public static boolean isValid(int start, List<int[]> times) {
        int time = start;
        for (int i = 0; i < times.size(); i++) {
            int[] cur = times.get(i);
            time += cur[0];
            if (time > cur[1]) {
                return false;
            }
        }
        return true;
    }
}
