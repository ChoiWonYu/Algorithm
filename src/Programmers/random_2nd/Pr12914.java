package Programmers.random_2nd;

public class Pr12914 {

    public long solution(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        return arr[n] % 1234567;
    }
}
