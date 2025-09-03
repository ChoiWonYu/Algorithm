package BOJ.dfsbfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Puzzle {

    public static final int SIZE = 3;

    public final int[][] board;
    public int zeroRow;
    public int zeroCol;

    public Puzzle(final int[][] board, final int zeroRow, final int zeroCol) {
        this.board = board;
        this.zeroCol = zeroCol;
        this.zeroRow = zeroRow;
    }

    public boolean isSameBoard(int[][] otherBoard) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (otherBoard[i][j] != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSameZeroLoc(int zeroRow, int zeroCol) {
        return this.zeroRow == zeroRow && this.zeroCol == zeroCol;
    }

    public static boolean isValid(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    public Puzzle makePuzzle(int row, int col) {
        int[][] newBoard = copyBoard();
        int tmp = newBoard[zeroRow + row][zeroCol + col];
        newBoard[zeroRow][zeroCol] = tmp;
        newBoard[zeroRow + row][zeroCol + col] = 0;
        return new Puzzle(newBoard, zeroRow + row, zeroCol + col);
    }

    public int[][] copyBoard() {
        int[][] newBoard = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, newBoard[i], 0, SIZE);
        }
        return newBoard;
    }
}

public class PuzzleDfs {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static List<int[][]> visited = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Puzzle answerPuzzle, startPuzzle;

        int[][] answerBoard = new int[3][3];
        int[][] startBoard = new int[3][3];

        int i, j, inputNum, num = 1;
        int zeroRow = 0;
        int zeroCol = 0;
        for (i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < 3; j++) {
                inputNum = Integer.parseInt(st.nextToken());

                if (inputNum == 0) {
                    zeroRow = i;
                    zeroCol = j;
                }

                answerBoard[i][j] = inputNum;
                startBoard[i][j] = num++;
            }
        }
        answerPuzzle = new Puzzle(answerBoard, zeroRow, zeroCol);
        startPuzzle = new Puzzle(startBoard, 2, 2);

        int count = calculateCount(startPuzzle, answerPuzzle);

        System.out.println(count);
    }

    private static int calculateCount(final Puzzle startPuzzle, final Puzzle answerPuzzle) {
        Queue<Puzzle> q = new LinkedList<>();
        q.offer(startPuzzle);
        int count = 0;

        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Puzzle puzzle = q.poll();
                for (int j = 0; j < 4; j++) {
                    //newPuzzle이 넘어가야됨
                    if (canPush(puzzle, puzzle.zeroRow + dr[j], puzzle.zeroCol + dc[j])) {
                        Puzzle newPuzzle = puzzle.makePuzzle(dr[j], dc[j]);
                        if (newPuzzle.isSameZeroLoc(answerPuzzle.zeroRow, answerPuzzle.zeroCol)
                            && newPuzzle.isSameBoard(answerPuzzle.board)) {
                            return count;
                        }
                        visited.add(newPuzzle.board);
                    }
                }
            }
        }
        return -1;
    }

    private static boolean canPush(Puzzle puzzle, int row, int col) {
        if (!Puzzle.isValid(row, col)) {
            return false;
        }

        boolean isVisited = visited.stream()
            .anyMatch(puzzle::isSameBoard);

        return !isVisited;
    }
}
