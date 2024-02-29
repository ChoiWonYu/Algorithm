package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        Arrays.sort(arr);
        long lp = 1;
        long rp = max + 1;
        while (lp + 1 < rp) {
            long mid = (lp + rp) / 2;
            if (isValid(arr, mid, k)) {
                lp = mid;
            } else {
                rp = mid;
            }
        }
        System.out.println(lp);
    }

    private static boolean isValid(final long[] arr, final long value, final int cnt) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] / value;
        }

        return sum >= cnt;
    }

}
