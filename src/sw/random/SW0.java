package sw.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SW0 {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nicks = new String[n];
        String[] emails = new String[n];
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i;
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            nicks[i] = st.nextToken();
            emails[i] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilarNick(nicks[i], nicks[j]) && isSimilarEmail(emails[i], emails[j])) {
                    union(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            find(i);
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            s.add(arr[i]);
        }

        System.out.println(s.size());
    }

    private static int find(final int i) {
        if (i == arr[i]) {
            return i;
        }
        return arr[i] = find(arr[i]);
    }

    private static void union(final int i, final int j) {
        int num1 = find(i);
        int num2 = find(j);

        arr[num1] = num2;
    }

    private static boolean isSimilarEmail(final String e1, final String e2) {
        String[] arr1 = e1.split("@");
        String[] arr2 = e2.split("@");
        String accountName1 = arr1[0];
        String accountName2 = arr2[0];
        String serverName1 = arr1[1];
        String serverName2 = arr2[1];

        if (isSimilarWord(1, accountName1, accountName2) && serverName1.equals(serverName2)) {
            return true;
        }
        if (accountName1.equals(accountName2)) {
            return true;
        }
        return false;
    }

    private static boolean isSimilarNick(final String n1, final String n2) {
        return isSimilarWord(2, n1, n2);
    }

    private static boolean isSimilarWord(final int cnt, final String n1, final String n2) {
        int curCnt = 0;
        String longN = n1.length() > n2.length() ? n1 : n2;
        String shortN = n1.length() > n2.length() ? n2 : n1;
        int shortP = 0;
        for (int longP = 0; longP < longN.length(); longP++) {
            if (shortP == shortN.length()) {
                curCnt++;
                continue;
            }
            if (longN.charAt(longP) != shortN.charAt(shortP)) {
                curCnt++;
            } else {
                shortP++;
            }

            if (curCnt > cnt) {
                return false;
            }
        }
        return true;
    }


}
