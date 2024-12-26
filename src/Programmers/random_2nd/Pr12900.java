package Programmers.random_2nd;

public class Pr12900 {

    public int solution(int n) {
        int[] methods = new int[n + 1];
        methods[1] = 1;
        if (n >= 2) {
            methods[2] = 2;
        }
        for (int i = 3; i <= n; i++) {
            methods[i] = (methods[i - 1] + methods[i - 2]) % 1000000007;
        }
        return methods[n] % 1000000007;
    }
}
