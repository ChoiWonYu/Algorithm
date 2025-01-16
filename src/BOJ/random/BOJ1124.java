package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1124 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[b + 1];
        int[] primes = new int[b + 1];
        Arrays.fill(isPrime, true);

        // 소수 값 결정
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= b; i++) {
            int mul = 2;
            while (i * mul <= b) {
                isPrime[i * mul++] = false;
            }
        }

        for (int i = 2; i <= b; i++) {
            if (isPrime[i]) {
                primes[i] = 1;
            }
        }

        // 소수가 아닌 수의 소수 개수 구하기
        for (int i = 2; i <= b; i++) {
            if (!isPrime[i]) {
                for (int j = 2; j < b; j++) {
                    if (isPrime[j] && i % j == 0) {
                        primes[i] = primes[i / j] + 1;
                        break;
                    }
                }
            }
        }

        // 언더프라임 구하기
        int answer = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime[primes[i]]) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}
