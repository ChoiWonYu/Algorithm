package BOJ.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BOJ2251 {

    static int[] max = new int[3];
    static Set<String> visited;
    static Set<Integer> answer = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            max[i] = sc.nextInt();
        }
        visited = new HashSet<>();
        int[] initialRemain = new int[]{0, 0, max[2]};
        visited.add(Arrays.toString(initialRemain));
        dfs(initialRemain);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

    private static void dfs(final int[] remain) {
        if (remain[0] == 0) {
            answer.add(remain[2]);
        }

        for (int i = 0; i < 3; i++) {
            if (remain[i] == 0) {
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (i == j || remain[j] == max[j]) {
                    continue;
                }
                int curRemain = remain[i];
                int targetRemain = remain[j];
                if (curRemain + targetRemain > max[j]) {
                    remain[j] = max[j];
                    remain[i] = curRemain + targetRemain - max[j];
                } else {
                    remain[j] = curRemain + targetRemain;
                    remain[i] = 0;
                }
                if (!visited.contains(Arrays.toString(remain))) {
                    visited.add(Arrays.toString(remain));
                    dfs(remain);
                }
                remain[i] = curRemain;
                remain[j] = targetRemain;
            }
        }
    }

}
