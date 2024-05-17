package Programmers.random_2nd;

public class Pr12985 {

    public int solution(int n, int a, int b) {
        int cnt = 0;
        while (a != b) {
            a = win(a);
            b = win(b);
            cnt++;
        }
        return cnt;
    }

    public int win(int n) {
        if (isOdd(n)) {
            return n / 2 + 1;
        } else {
            return n / 2;
        }
    }

    public boolean isOdd(int n) {
        return n % 2 != 0;
    }
}
