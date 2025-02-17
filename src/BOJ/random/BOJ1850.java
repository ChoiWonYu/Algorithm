package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = calculateGCD(a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < gcd; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long calculateGCD(long num1, long num2) {
        while (num2 != 0) {
            long tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }
}
