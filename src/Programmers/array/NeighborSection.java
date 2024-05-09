package Programmers.array;

public class NeighborSection {

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = new int[]{0, 1, -1, 0};
        int[] dw = new int[]{1, 0, 0, -1};
        String target = board[h][w];
        for (int i = 0; i < dh.length; i++) {
            int r = h + dh[i];
            int c = w + dw[i];
            if (r >= 0 && c >= 0 && r < board.length && c < board.length && target.equals(
                board[r][c])) {
                answer++;
            }

        }
        return answer;
    }
}
