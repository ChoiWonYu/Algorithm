package sw.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SW1228 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                List<Integer> tmp = new ArrayList<>();
                for (int j = 0; j < y; j++) {
                    tmp.add(sc.nextInt());
                }
                list.addAll(x, tmp);
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
