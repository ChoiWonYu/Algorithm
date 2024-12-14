package Programmers.random_2nd;

public class Pr92335 {

    public int solution(int n, int k) {
        int answer = 0;
        String num = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        for (char cur : num.toCharArray()) {
            if (cur == '0') {
                if (sb.isEmpty()) {
                    continue;
                }
                if (isValid(sb)) {
                    answer++;
                }
                sb.setLength(0);
            } else {
                sb.append(cur);
            }
        }
        if (!sb.isEmpty() && isValid(sb)) {
            answer++;
        }
        return answer;
    }

    public boolean isValid(StringBuilder sb) {
        return isPrime(Long.parseLong(sb.toString()));
    }

    public boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
