package BOJ.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Postfix2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Double> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        double[] nums = new double[n];

        String postfix = br.readLine();
        for (int i = 0; i < n; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        postfix.chars()
            .forEach(ch -> {
                if (Character.isAlphabetic(ch)) {
                    deque.push(nums[ch - 65]);
                    return;
                }
                deque.push(calculate(deque.pop(), deque.pop(), (char) ch));
            });
        System.out.printf("%.2f", deque.pop());

    }

    private static double calculate(final Double num1, final Double num2, final char operator) {
        switch (operator) {
            case '*':
                return num1 * num2;
            case '+':
                return num1 + num2;
            case '/':
                return num2 / num1;
            case '-':
                return num2 - num1;
        }
        return -1;
    }

}
