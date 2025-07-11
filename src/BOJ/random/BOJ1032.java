package BOJ.random;

import java.util.Scanner;

public class BOJ1032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.next();
        }

        StringBuilder sb = new StringBuilder();
        boolean flag;
        for (int i = 0; i < arr[0].length(); i++) {
            char cur = arr[0].charAt(i);
            flag = true;
            for(int j=1; j<arr.length; j++) {
                if(cur != arr[j].charAt(i)) {
                    sb.append('?');
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(cur);
            }
        }
        System.out.println(sb);
    }

}
