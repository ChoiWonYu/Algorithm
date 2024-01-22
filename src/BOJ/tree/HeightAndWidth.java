package BOJ.tree;

import java.io.*;
import java.util.*;

class Node {

    int data;
    int parent;
    int right;
    int left;

    public Node(final int data) {
        this.data = data;
        this.parent = -1;
        this.left = -1;
        this.right = -1;
    }
}

public class HeightAndWidth {

    static List<Node> t;
    static List<Integer> nums = new ArrayList<>();
    static int[] minLv, maxLv;
    static int xLoc = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rootIdx = -1;
        int n = Integer.parseInt(br.readLine());
        minLv = new int[n + 1];
        Arrays.fill(minLv, n);
        maxLv = new int[n + 1];
        t = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i <= n; i++) {
            t.add(new Node(i));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            t.get(root).left = left;
            t.get(root).right = right;

            if (left != -1) {
                t.get(left).parent = root;
            }
            if (right != -1) {
                t.get(right).parent = root;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (t.get(i).parent == -1) {
                rootIdx = i;
                break;
            }
        }

        inOrder(rootIdx, 1);

        int resultLv = -1;
        int resultWidth = -1;
        for (int lv = 1; lv <= n; lv++) {
            if (resultWidth < maxLv[lv] - minLv[lv] + 1) {
                resultWidth = maxLv[lv] - minLv[lv] + 1;
                resultLv = lv;
            }
        }

        System.out.println(resultLv + " " + resultWidth);
    }

    private static void findMaxWidth() {

    }

    private static void inOrder(final int idx, final int level) {
        int left = t.get(idx).left;
        int right = t.get(idx).right;

        if (left != -1) {
            inOrder(left, level + 1);
        }
        nums.add(idx);
        minLv[level] = Math.min(minLv[level], xLoc);
        maxLv[level] = Math.max(maxLv[level], xLoc);
        xLoc++;
        if (right != -1) {
            inOrder(right, level + 1);
        }
    }

}
