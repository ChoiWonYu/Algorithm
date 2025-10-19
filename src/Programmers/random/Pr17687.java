package Programmers.random;

public class Pr17687 {

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() <= m * t) {
            sb.append(Integer.toString(num++, n));
        }

        StringBuilder answer = new StringBuilder();
        int curIdx = p - 1;
        for (int i = 0; i < t; i++) {
            char cur = sb.charAt(curIdx);
            if (Character.isAlphabetic(cur)) {
                cur = Character.toUpperCase(cur);
            }
            answer.append(cur);
            curIdx += m;
        }
        return answer.toString();
    }
}
