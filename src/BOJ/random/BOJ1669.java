package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1669 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long m = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long diff = d - m;
        if (diff <= 2) {
            System.out.println(diff);
            return;
        }

        long start = 1;
        long end = 1;
        long day = 2;
        long sum = start + end;
        boolean startF = true;
        while (sum < diff) {
            if (startF) {
                if (diff - sum > start) {
                    start++;
                }
                sum += start;
                startF = false;
            } else {
                if (diff - sum > end) {
                    end++;
                }
                sum += end;
                startF = true;
            }
            day++;
        }
        System.out.println(day);
    }
}
