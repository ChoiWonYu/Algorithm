package BOJ.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2877 {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 2;
        int i = 1;
        while (true) {
            i++;
            if (k >= start && k <= end) {
                break;
            }
            start = end + 1;
            end += (int)Math.pow(2, i);
        }
        i--;

        int order = 0;
        while (start < end) {
            order++;
            int mid = (start + end) / 2;
            if (k == mid) {
                sb.append(4);
                break;
            } else if (k > mid) {
                sb.append(7);
                start = mid + 1;
            } else {
                sb.append(4);
                end = mid;
            }
        }
        for (int j = order; j < i; j++) {
            sb.append(7);
        }
        System.out.println(sb);
    }

}
