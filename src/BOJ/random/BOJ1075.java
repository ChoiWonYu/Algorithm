package BOJ.random;

import java.util.Scanner;

public class BOJ1075 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();
        String first = String.valueOf(n).substring(0, String.valueOf(n).length() - 2);
        for (int i = 0; i < 100; i++) {
            String cur = i < 10 ? "0" + i : String.valueOf(i);
            String target = first + cur;
            if (Integer.parseInt(target) % f == 0) {
                System.out.println(cur);
                return;
            }
        }
    }

}
