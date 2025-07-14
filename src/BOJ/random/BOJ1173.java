package BOJ.random;

import java.util.Scanner;

public class BOJ1173 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetCnt = sc.nextInt();
        int min = sc.nextInt();
        int max = sc.nextInt();
        int training = sc.nextInt();
        int resting = sc.nextInt();

        if (min + training > max) {
            System.out.println(-1);
            return;
        }

        int cur = min;
        int curCnt = 0;
        int answer = 0;
        while (curCnt < targetCnt) {
            answer++;
            if (cur + training <= max) {
                curCnt++;
                cur += training;
            } else {
                cur = Math.max(cur - resting, min);
            }
        }
        System.out.println(answer);
    }

}
