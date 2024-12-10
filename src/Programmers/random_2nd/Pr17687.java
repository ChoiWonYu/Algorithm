package Programmers.random_2nd;

public class Pr17687 {

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        int turn = 0;
        while (turn < t * m) {
            if (turn % m == p - 1) {
                answer.append(sb.charAt(turn));
            }
            turn++;
        }
        return answer.toString().toUpperCase();
    }
}
