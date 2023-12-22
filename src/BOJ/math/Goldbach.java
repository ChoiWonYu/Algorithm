package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach {

    private static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i, input;

        //에라토스테네스의 체
        boolean[] isPrime = new boolean[MAX + 1];
        for (i = 0; i <= MAX; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = isPrime[1] = false;

        for (i = 2; i <= Math.sqrt(MAX); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while ((input = Integer.parseInt(br.readLine())) != 0) {
            for (i = 3; i < input; i++) {
                if (isPrime[i] && i % 2 == 1 && isPrime[input - i] && (input - i) % 2 == 1) {
                    sb.append(input).append(" = ").append(i).append(" + ").append(input - i)
                        .append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

}
