package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1024 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long l = Integer.parseInt(st.nextToken());

        for (long i = l; i <= 100; i++) {
            long sum = i * (i - 1) / 2;
            if (sum > n) {
                break;
            }
            if ((n - sum) % i == 0) {
                long start = (n - sum) / i;
                if (start >= 0) {
                    for (long j = 0; j < i; j++) {
                        System.out.print((start + j) + " ");
                    }
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
