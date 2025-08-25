package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {

    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr[i] = cur;
            sum += cur;
        }
        int lp = 0;
        int rp = sum;
        while (lp + 1 < rp) {
            int mid = (lp + rp) / 2;
            if (isValid(mid)) {
                rp = mid;
            } else {
                lp = mid;
            }
        }
        System.out.println(rp);
    }

    static boolean isValid(int num) {
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > num) {
                return false;
            }
            sum += arr[i];
            if (sum > num) {
                cnt++;
                sum = arr[i];
            }
        }
        return cnt <= m;
    }
}
