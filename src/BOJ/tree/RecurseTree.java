package BOJ.tree;

import java.io.*;
import java.util.*;

public class RecurseTree {

    private static final int ASCII_VALUE = 65;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int root = input.charAt(0);
            int left = input.charAt(2);
            int right = input.charAt(4);
            tree.get(root - ASCII_VALUE).add(left);
            tree.get(root - ASCII_VALUE).add(right);
        }
        post(0);
        sb.append("\n");

        mid(0);
        sb.append("\n");

        back(0);
        System.out.println(sb);
    }

    private static void back(final int idx) {
        for (int n : tree.get(idx)) {
            if ((char) n == '.') {
                continue;
            }
            back(n - ASCII_VALUE);
        }
        sb.append((char) (idx + ASCII_VALUE));
    }

    private static void mid(final int idx) {
        int left = tree.get(idx).get(0);
        int right = tree.get(idx).get(1);

        if ((char) left != '.') {
            mid(left - ASCII_VALUE);
        }
        sb.append((char) (idx + ASCII_VALUE));
        if ((char) right != '.') {
            mid(right - ASCII_VALUE);
        }
    }

    private static void post(final int idx) {
        sb.append((char) (idx + ASCII_VALUE));
        for (int n : tree.get(idx)) {
            if ((char) n == '.') {
                continue;
            }
            post(n - ASCII_VALUE);
        }
    }

}
