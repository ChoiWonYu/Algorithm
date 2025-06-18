package BOJ.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1043 {

    static List<Integer> known = new ArrayList<>();
    static int[] unf;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int curKnown = sc.nextInt();
            known.add(curKnown);
        }

        // 진실을 아는 사람들 union
        if (known.size() > 1) {
            for (int i = 1; i < known.size(); i++) {
                union(known.get(i - 1), known.get(i));
            }
        }

        // 파티에 오는 사람들 저장, 과장을 알게 될 사람 업데이트
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                cur.add(sc.nextInt());
            }

            if (num > 1) {
                for (int j = 1; j < cur.size(); j++) {
                    union(cur.get(j), cur.get(j - 1));
                }
            }
            parties.add(cur);
        }

        // 과장할 수 있는 파티 개수 구하기
        if (known.isEmpty()) {
            answer = m;
        } else {
            int knownP = known.get(0);
            for (int i = 0; i < m; i++) {
                boolean canLie = true;
                for (int participant : parties.get(i)) {
                    if (find(participant) == find(knownP)) {
                        canLie = false;
                        break;
                    }
                }
                if (canLie) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int n1 = find(a);
        int n2 = find(b);
        if (n1 != n2) {
            unf[n1] = n2;
        }
    }

    static int find(int x) {
        if (unf[x] == x) {
            return x;
        }
        return unf[x] = find(unf[x]);
    }
}
