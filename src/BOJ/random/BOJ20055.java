package BOJ.random;

import java.util.Scanner;

public class BOJ20055 {

    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] belt = new int[2 * n];
        boolean[] robots = new boolean[n];
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = sc.nextInt();
        }
        cnt = 0;
        int step = 0;

        while (true) {
            // 벨트 회전
            rotate(belt, robots);

            // 로봇 이동
            moveRobots(belt, robots);

            // 로봇 추가
            addRobot(belt, robots);

            step++;
            if (cnt >= k) {
                break;
            }
        }

        System.out.println(step);
    }

    private static void addRobot(final int[] belt, final boolean[] robots) {
        if (belt[0] > 0 && !robots[0]) {
            robots[0] = true;
            belt[0]--;
            if (belt[0] == 0) {
                cnt++;
            }
        }
    }

    private static void moveRobots(final int[] belt, final boolean[] robots) {
        int len = robots.length;
        for (int i = len - 1; i >= 1; i--) {
            if (robots[i - 1] && belt[i] > 0 && !robots[i]) {
                robots[i - 1] = false;
                robots[i] = true;
                belt[i]--;
                if (belt[i] == 0) {
                    cnt++;
                }
                if (robots[len - 1]) {
                    robots[len - 1] = false;
                }
            }
        }
    }

    private static void rotate(int[] belt, boolean[] robots) {
        int len = belt.length;
        int[] newBelt = new int[len];
        newBelt[0] = belt[len - 1];
        for (int i = 1; i < len; i++) {
            newBelt[i] = belt[i - 1];
            belt[i - 1] = newBelt[i - 1];
        }
        belt[len - 1] = newBelt[len - 1];

        for (int i = len / 2 - 1; i >= 1; i--) {
            if (robots[i - 1]) {
                robots[i] = true;
                robots[i - 1] = false;
            }
        }
        if (robots[len / 2 - 1]) {
            robots[len / 2 - 1] = false;
        }
    }
}
