package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class Dwarf {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] l = new int[9];

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            l[i] = Integer.parseInt(br.readLine());
            sum += l[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (100 == sum - l[i] - l[j]) {
                    l[i] = 0;
                    l[j] = 0;
                    Arrays.sort(l);

                    for (int k = 2; k < 9; k++) {
                        System.out.println(l[k]);
                    }
                }
            }
        }
    }

    private static void printHeight(final List<Integer> l, final int num1, final int num2) {
        StringBuilder sb = new StringBuilder();
        l.stream()
            .filter(n -> !n.equals(l.get(num1)) && !n.equals(l.get(num2)))
            .sorted()
            .forEach(n -> sb.append(n).append("\n"));

        System.out.println(sb);
    }

}
