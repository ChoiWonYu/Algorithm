package BOJ.random;

import java.io.*;
import java.util.*;

public class BOJ2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lp = 0;
        int rp = arr[n - 1] + 1;
        while (lp + 1 < rp) {
            int mid = (lp + rp) / 2;
            if (isValid(arr, mid, c)) {
                lp = mid;
            } else {
                rp = mid;
            }
        }

        System.out.println(lp);
    }

    private static boolean isValid(final int[] arr, final int value, final int cnt) {
        int prev = arr[0];
        int target = prev + value;
        int c = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= target) {
                prev = arr[i];
                target = prev + value;
                c++;
            }
        }
        return c >= cnt;
    }
}
