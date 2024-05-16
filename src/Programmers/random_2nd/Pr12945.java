package Programmers.random_2nd;

public class Pr12945 {

    public static int[] memo = new int[100001];

    public int solution(int n) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < n; i++) {
            memo[i] = (memo[i - 1] + memo[i - 2]) % 1234567;
        }
        return (memo[n - 1] + memo[n - 2]) % 1234567;
    }
}
