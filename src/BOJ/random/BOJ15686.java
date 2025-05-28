package BOJ.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ15686 {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] map, cur;
    static List<int[]> houses, stores;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];
        cur = new int[m][2];
        houses = new ArrayList<>();
        stores = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    stores.add(new int[]{i, j});
                }
            }
        }
        getStoresCombinations(0, -1);
        System.out.println(answer);
    }

    private static void getStoresCombinations(final int idx, final int prev) {
        if (idx == m || idx == stores.size()) {
            calculateMin();
            return;
        }
        for (int i = prev + 1; i < stores.size(); i++) {
            cur[idx] = stores.get(i);
            getStoresCombinations(idx + 1, i);
        }
    }

    private static void calculateMin() {
        int result = 0;
        for (int[] h : houses) {
            int min = Integer.MAX_VALUE;
            for (int[] i : cur) {
                min = Math.min(min, Math.abs(i[0] - h[0]) + Math.abs(i[1] - h[1]));
            }
            result += min;
        }
        answer = Math.min(result, answer);
    }
}
