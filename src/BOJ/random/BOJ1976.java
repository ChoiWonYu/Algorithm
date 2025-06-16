package BOJ.random;

import java.util.Scanner;

public class BOJ1976 {

    static int[] unf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        unf = new int[n];
        for(int i=0; i<n; i++) {
            unf[i] = i;
        }
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() == 1) {
                    union(i, j);
                }
            }
        }
        int num = -1;
        String answer = "YES";
        for (int i = 0; i < m; i++) {
            int cur = find(sc.nextInt() - 1);
            if (num == -1) {
                num = cur;
            }
            if (cur != num) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

    private static int find(final int i) {
        if (unf[i] == i) {
            return i;
        }
        return unf[i] = find(unf[i]);
    }

    private static void union(final int i, final int j) {
        int n1 = find(i);
        int n2 = find(j);
        unf[n1] = n2;
    }

}
