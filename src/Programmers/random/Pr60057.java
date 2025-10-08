package Programmers.random;

public class Pr60057 {

    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(pressWordLen(s, i), answer);
        }
        return answer;
    }

    public int pressWordLen(String s, int n) {
        int len = s.length();
        int lp = 0;
        StringBuilder sb = new StringBuilder();
        while (lp <= len - n) {
            String cur = s.substring(lp, lp + n);
            int cnt = 1;
            while (lp + n <= len - n && cur.equals(s.substring(lp + n, lp + 2 * n))) {
                lp += n;
                cnt++;
            }
            if (cnt > 1) {
                sb.append(cnt);
            }
            sb.append(cur);
            lp += n;
        }

        // System.out.println("s: " + s);
        // System.out.println("n: " + n);
        // System.out.println("press: " + sb.toString());
        // System.out.println();
        return sb.length() + len - lp;
    }
}
