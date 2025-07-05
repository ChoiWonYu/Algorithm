package BOJ.random;

import java.util.Scanner;

public class BOJ1100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int answer = 0;
        for(int i=0; i<8; i++) {
            if (i % 2 == 0) {
                flag = true;
            } else {
                flag = false;
            }
            String line = sc.next();
            for(int j=0; j<8; j++) {
                char cur = line.charAt(j);
                if (flag && cur == 'F') {
                    answer++;
                }
                flag = !flag;
            }
        }
        System.out.println(answer);

    }

}
