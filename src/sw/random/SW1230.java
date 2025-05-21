package sw.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SW1230 {

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(sc.nextInt());
            }
            int cmdCnt = sc.nextInt();
            for (int i = 0; i < cmdCnt; i++) {
                String cmd = sc.next();
                switch (cmd) {
                    case "I":
                        insert(sc, nums);
                        break;
                    case "A":
                        append(sc, nums);
                        break;
                    default:
                        delete(sc, nums);
                        break;
                }
            }
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(nums.get(i) + " ");
            }
            System.out.println();
        }
    }

    public static void insert(Scanner sc, List<Integer> nums) throws Exception {
        int x = sc.nextInt();
        int y = sc.nextInt();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            tmp.add(sc.nextInt());
        }
        nums.addAll(x, tmp);
    }

    public static void append(Scanner sc, List<Integer> nums) throws Exception {
        int y = sc.nextInt();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            tmp.add(sc.nextInt());
        }
        nums.addAll(tmp);
    }

    public static void delete(Scanner sc, List<Integer> nums) throws Exception {
        int x = sc.nextInt();
        int y = sc.nextInt();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            if (i == x) {
                i += y;
            } else {
                tmp.add(nums.get(i));
            }
        }
    }
}
