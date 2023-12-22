package BOJ.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i, input, mul;

        boolean[] noPrime = new boolean[1000001];
        noPrime[1] = true;
        for (i = 2; i <= 1000000; i++) {
            mul = 2;
            while (i * mul <= 1000000) {
                noPrime[i * mul++] = true;
            }
        }

        while ((input = Integer.parseInt(br.readLine())) != 0) {
            for (i = 3; i < input; i++) {
                if (!noPrime[i] && i % 2 == 1 && !noPrime[input - i] && (input - i) % 2 == 1) {
                    sb.append(input).append(" = ").append(i).append(" + ").append(input - i)
                        .append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

}
