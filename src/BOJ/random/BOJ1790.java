package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1790 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int t = 0;
        while (k > 9 * (long) Math.pow(10, t) * (t + 1)) {
            k -= 9 * (long) Math.pow(10, t) * (t + 1);
            t++;
        }

        long order = k % (t + 1) == 0 ? k / (t + 1) - 1 : k / (t + 1);
        int idx = (int) (k % (t + 1));
        if (idx == 0) {
            idx = t + 1;
        }
        long target = (long) Math.pow(10, t) + order;
        if (target > n) {
            System.out.println(-1);
            return;
        }
        System.out.println(Long.toString(target).charAt(idx - 1));
    }

}
