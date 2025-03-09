package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1484 {

    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long w = 1;
        while (w * w <= n) {
            w++;
        }

        for (long i = w; i <= MAX; i++) {
            long minus = i*i - n;
            if (isValid(minus)) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }

    public static boolean isValid(long n) {
        return Math.ceil(Math.sqrt(n)) == Math.sqrt(n);
    }
}
