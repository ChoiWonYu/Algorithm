package Programmers.array;

public class Bandage {

    public int solution(int[] bandage, int health, int[][] attacks) {
        int init = health;
        int prevAttatckTime = 0;

        for (int i = 0; i < attacks.length; i++) {
            int[] cur = attacks[i];
            int t = cur[0] - prevAttatckTime - 1;
            health = Math.min((health + ((t * bandage[1]))), init);
            if (t >= bandage[0]) {
                health = Math.min((health + bandage[2] * (t / bandage[0])), init);
            }
            health -= cur[1];

            if (health <= 0) {
                return -1;
            }
            prevAttatckTime = cur[0];
            System.out.println(health);
        }
        return health;
    }
}
