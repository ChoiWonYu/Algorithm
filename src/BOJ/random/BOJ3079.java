package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3079 {

    public static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        long min = arr[0];
        long lp = min;
        long rp = min * m;

        while (lp + 1 < rp) {
            long mid = (lp + rp) / 2;
            if (isValid(mid, m)) {
                rp = mid;
            } else {
                lp = mid;
            }
        }

        System.out.println(rp);
    }

    public static boolean isValid(long num, long friends) {
        long cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            cnt += num / arr[i];
            if (cnt > friends) {
                return true;
            }
        }
        return cnt >= friends;
    }

}
