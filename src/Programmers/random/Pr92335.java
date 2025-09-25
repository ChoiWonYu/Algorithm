package Programmers.random;

public class Pr92335 {

    public int solution(int n, int k) {
        int answer = 0;
        String target = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char cur = target.charAt(i);
            if (cur == '0') {
                String curNum = sb.toString();
                sb.setLength(0);
                if (curNum.isEmpty() || !isPrime(Long.parseLong(curNum))) {
                    continue;
                }
                answer++;
            } else {
                sb.append(cur);
            }
        }
        String curNum = sb.toString();
        if (!curNum.isEmpty() && isPrime(Long.parseLong(curNum))) {
            answer++;
        }
        return answer;
    }

    public boolean isPrime(long num) {
        if (num == 1 || num == 0) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
