package Programmers.greedy;

import java.util.*;

public class ConnectIsland {

    static int[] unf;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int result = solution(n, costs);
        System.out.println(result);
    }

    private static int solution(final int n, final int[][] costs) {
        Arrays.sort(costs, (arr1, arr2) -> arr1[2] - arr2[2]);
        unf = new int[n];

        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }

        int num1, num2, cost;
        int sum = 0;
        for (int[] info : costs) {
            num1 = info[0];
            num2 = info[1];
            cost = info[2];

            if (union(num1, num2)) {
                sum += cost;
            }
        }

        return sum;
    }

    public static boolean union(int num1, int num2) {
        int n1 = find(num1);
        int n2 = find(num2);

        if (n1 == n2) {
            return false;
        }
        unf[n1] = n2;
        return true;
    }

    public static int find(int num) {
        if (unf[num] == num) {
            return num;
        }

        return unf[num] = find(unf[num]);
    }
}
