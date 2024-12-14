package Programmers.random_2nd;

public class Pr49994 {

    public int solution(String dirs) {
        boolean[][] visited = new boolean[121][121];
        int curX = 5;
        int curY = 5;
        int answer = 0;
        for (char curD : dirs.toCharArray()) {
            int nextX = curX;
            int nextY = curY;
            if (curD == 'U') {
                nextY = curY + 1;
            }
            if (curD == 'D') {
                nextY = curY - 1;
            }
            if (curD == 'R') {
                nextX = curX + 1;
            }
            if (curD == 'L') {
                nextX = curX - 1;
            }

            if (!isValid(nextX, nextY)) {
                continue;
            }

            int start = curX * 11 + curY;
            int end = nextX * 11 + nextY;
            if (!visited[start][end]) {
                visited[start][end] = true;
                visited[end][start] = true;
                answer++;
            }
            curX = nextX;
            curY = nextY;
        }
        return answer;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }
}
