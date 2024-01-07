package BOJ.bruteForce;

import java.io.*;

public class NumberLength {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int mul = 1;
        while (n / Math.pow(10, mul) >= 1) {
            mul++;
        }

        int result = 0;
        for (int i = 1; i < mul; i++) {
            result += ((int) Math.pow(10, i) - (int) Math.pow(10, i - 1)) * i;
        }
        result += (n - (int) Math.pow(10, mul - 1) + 1) * mul;

        System.out.println(result);
    }

}
