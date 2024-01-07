package BOJ.bruteForce;

import java.util.*;
import java.io.*;

public class Calender {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int m, n, x, y, mul;
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int gcd = calculateGcd(m, n);
            int lcm = m * n / gcd;
            mul = 0;
            if (x == m && y == n) {
                sb.append(lcm).append("\n");
                continue;
            }
            while (m * mul <= lcm) {
                if ((((m * mul) + x) - y) % n == 0) {
                    sb.append(m * mul + x).append("\n");
                    break;
                }
                mul++;
            }
            if (m * mul > lcm) {
                sb.append(-1).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int calculateGcd(final int a, final int b) {
        if (b == 0) {
            return a;
        }

        return calculateGcd(b, a % b);
    }

}
