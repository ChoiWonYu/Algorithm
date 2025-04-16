package BOJ.random;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ3649 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            long answer = Integer.parseInt(sc.nextLine()) * 10000000L;
            int n = Integer.parseInt(sc.nextLine());
            if (n == 0) {
                sb.append("danger").append("\n");
                continue;
            }
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(sc.nextLine());
            }

            Arrays.sort(arr);
            int rp = n - 1;
            int lp;
            for (lp = 0; lp < rp; lp++) {
                while (lp < rp && (arr[lp] + arr[rp] > answer)) {
                    rp--;
                }
                if (arr[rp] + arr[lp] == answer) {
                    break;
                }
            }
            if (rp == lp || arr[rp] + arr[lp] != answer) {
                sb.append("danger");
            } else {
                sb.append("yes ").append(arr[lp]).append(" ").append(arr[rp]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
