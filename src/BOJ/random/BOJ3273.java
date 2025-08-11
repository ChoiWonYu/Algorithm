package BOJ.random;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }
        int x = sc.nextInt();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (set.contains(x - arr[i])) {
                answer++;
            }
        }

        System.out.println(answer / 2);
    }

}
