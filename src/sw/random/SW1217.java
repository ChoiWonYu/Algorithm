package sw.random;

import java.util.Scanner;

public class SW1217 {

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;

        for(int test_case = 1; test_case <= T; test_case++)
        {

            int tc = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            int answer = pow(n,m);
            System.out.println("#" + tc + " " + answer);
        }
    }

    public static int pow(int n, int m){
        if(m == 0) return 1;
        return pow(n, m - 1) * n;
    }
}
