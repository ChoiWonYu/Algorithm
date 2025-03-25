package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {

    static int[] firstPrime = new int[]{2, 3, 5, 7};
    static int[] restPrime = new int[]{1, 3, 7, 9};
    static StringBuilder sb = new StringBuilder();
    static int limit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        limit = Integer.parseInt(br.readLine());
        dfs(0);
        System.out.println(sb);
        br.close();
    }

    static void dfs(int n) {
        if (n / (int) Math.pow(10, limit - 1) != 0) {
            sb.append(n).append("\n");
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (n == 0) {
                dfs(firstPrime[i]);
            } else {
                int next = n * 10 + restPrime[i];
                if (isPrime(next)) {
                    dfs(next);
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
