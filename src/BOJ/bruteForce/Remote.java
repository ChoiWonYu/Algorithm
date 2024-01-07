package BOJ.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Remote {

    static List<Integer> broken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        broken = new ArrayList<>();
        StringTokenizer st;
        if (n > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                broken.add(Integer.parseInt(st.nextToken()));
            }
        }

        int rp = target;
        int lp = target;
        int cnt = 0;

        while (rp != 100 && lp != 100) {
            if (canRemote(rp)) {
                System.out.println(
                    Math.min(String.valueOf(rp).length() + cnt, Math.abs(100 - target)));
                return;
            }
            rp = rp == 0 ? 0 : rp - 1;

            if (canRemote(lp)) {
                System.out.println(
                    Math.min(String.valueOf(lp).length() + cnt, Math.abs(100 - target)));
                return;
            }
            lp++;
            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean canRemote(final int num) {
        return String.valueOf(num).chars()
            .noneMatch(n -> broken.contains(n - 48));
    }

}
