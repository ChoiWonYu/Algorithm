package BOJ.bruteForce;

import java.io.*;
import java.util.*;

public class Dwarf {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            l.add(Integer.parseInt(br.readLine()));
        }
        int sum;

        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                sum = 0;
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < 9; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    sum += l.get(k);
                }
                if (sum == 100) {
                    printHeight(l, i, j);
                    return;
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
