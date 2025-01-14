package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1500 {

    public static long s, k, answer = Long.MIN_VALUE;
    public static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        long div = (long) s / k;
        if (s % k == 0) {
            System.out.println((long) Math.pow(div, k));
        } else {
            System.out.println((long) Math.pow(div, k - s % k) * (long)Math.pow(div + 1, s % k));
        }
    }
}
