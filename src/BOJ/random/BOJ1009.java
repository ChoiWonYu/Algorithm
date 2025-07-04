package BOJ.random;

import java.util.Scanner;

public class BOJ1009 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for (int t = 0; t < test_case; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int tmp = 1;
            for (int i = 0; i < b; i++) {
                tmp = (tmp * a) % 10;
            }
            System.out.println(tmp == 0 ? 10 : tmp);
        }

    }

}
