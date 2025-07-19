package BOJ.random;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1259 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        while (!(input = sc.next()).equals("0")) {
            if (isPalindrome(input)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static boolean isPalindrome(final String input) {
        Deque<Character> d = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            d.push(input.charAt(i));
        }
        while (d.size() > 1) {
            char c1 = d.pollFirst();
            char c2 = d.pollLast();
            if(c1 != c2) {
                return false;
            }
        }
        return true;
    }

}
