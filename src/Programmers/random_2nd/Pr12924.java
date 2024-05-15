package Programmers.random_2nd;

public class Pr12924 {

    public int solution(int n) {
        int lp = 0;
        int cnt = 0;
        for (int rp = 0; rp <= n; rp++) {
            int result = getSum(rp) - getSum(lp);
            while (n < result) {
                lp++;
                result = getSum(rp) - getSum(lp);
            }
            if (result == n) {
                cnt++;
            }
        }
        return cnt;
    }

    public int getSum(int n) {
        return n * (n + 1) / 2;
    }
}
