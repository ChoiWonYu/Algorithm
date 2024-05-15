package Programmers.random_2nd;

public class Pr12911 {

    public int solution(int n) {
        int answer = n + 1;
        while (!hasSameCount(answer, n)) {
            answer++;
        }
        return answer;
    }

    public boolean hasSameCount(int n, int m) {
        String ns = Integer.toBinaryString(n);
        String ms = Integer.toBinaryString(m);

        int nsCnt = 0;
        int msCnt = 0;
        for (int i = 0; i < ns.length(); i++) {
            if (ns.charAt(i) == '1') {
                nsCnt++;
            }
        }
        for (int i = 0; i < ms.length(); i++) {
            if (ms.charAt(i) == '1') {
                msCnt++;
            }
        }
        return nsCnt == msCnt;
    }
}
